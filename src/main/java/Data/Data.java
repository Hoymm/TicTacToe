package Data;
import Data.Board.BoardController;
import Data.Board.BoardData;
import Data.Messenger.MessageKeys;
import Data.Messenger.Messenger;
import Data.Players.Player;
import Data.Players.Players;
import Data.round.RoundState;
import GameState.UserIO.InputParams;

import java.util.Objects;
import java.util.logging.Logger;

public class Data {
    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());
    private Players players;
    private BoardController gameBoardController;
    private int roundsPlayed;
    private Messenger messenger;

    public Data(){
        roundsPlayed = 0;
    }

    public Data(String userInput, Messenger messenger) {
        this.messenger = messenger;
        insertGameStartData(userInput);
    }

    public Data(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(players, data.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, gameBoardController);
    }


    public void changePlayerToOpposite() {
        players.changePlayerTurn();
    }


    public String gameHeaderDisplayInfo() {
        return players.toString();
    }


    public String gameBoardDisplayInfo() {
        return gameBoardController.toString();
    }

    public boolean insertGameStartData(String userInput) {
        System.out.println("|||||||" + userInput + "|||||||||||||");
        try {
            String[] userInputArray = userInput.split(InputParams.SEPARATOR);

            Player playerO = new Player(userInputArray[0], Symbol.O);
            Player playerX = new Player(userInputArray[1], Symbol.X);
            Symbol startSymbol = Symbol.valueOf(userInputArray[2]);
            int howManySymbolsInRowToWin = Integer.valueOf(userInputArray[3]);
            int width = Integer.valueOf(userInputArray[4]);
            Integer height = Integer.valueOf(userInputArray[5]);

            players = new Players(playerO, playerX, startSymbol, messenger);
            BoardData gameBoardData = new BoardData(width, height);
            gameBoardController = new BoardController(gameBoardData, howManySymbolsInRowToWin);
            return true;
        }
        catch (Exception e){
            // TODO change that logger output
            LOGGER.warning("Something went wrong when converting user start data input into data objects");
            return false;
        }
    }


    public RoundState getRoundState() {
        return gameBoardController.getRoundState();
    }


    public boolean insertNewCoordinates(int userInput){
        if (!gameBoardController.tryMarkFieldAndChangeWinnerStateIfNeeded(userInput, players.getCurrentSymbol())) {
            messenger.print(MessageKeys.youCannotMarkAGameField, userInput);
            return false;
        }
        return true;
    }


    public boolean isGameFinished() {
        return roundsPlayed == 3;
    }


    public void incrementRoundsPlayed() {
        roundsPlayed++;
    }


    public void prepareNewRound() {
        gameBoardController.resetBoard();
        gameBoardController.setRoundStateToUnfinished();
    }


    public void addNewPointsToPlayers() {
        getRoundState().addPointsAccordingRoundFinishedState(players);
    }


    public String gameFinishResult() {
        if (isGameFinished())
            return players.gameFinishedMessage();
        else
            return messenger.translateKey(MessageKeys.gameInProgress);
    }

    public void printRoundState() {
        RoundState roundState = gameBoardController.getRoundState();
        messenger.print(roundState.getMessageKey(), roundState.getMessageKeyArguments());
    }
}
