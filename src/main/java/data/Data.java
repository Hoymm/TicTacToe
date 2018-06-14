package data;
import data.board.BoardController;
import data.board.BoardData;
import messenger.MessageKeys;
import messenger.Messenger;
import data.players.Player;
import data.players.Players;
import data.round.roundState.RoundState;
import gameState.userIO.startSettingsInput.StartSettings;
import java.util.Objects;
import java.util.logging.Logger;

public class Data {
    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());
    private Players players;
    private BoardController gameBoardController;
    private int roundsPlayed;

    public Data(StartSettings startSettings) {
        insertGameStartData(startSettings);
    }

    public Data(){
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

    public void changeCurrentPlayerToOpposite() {
        players.changePlayerTurn();
    }

    public String gameHeaderDisplayInfo() {
        return players.toString();
    }

    public String gameBoardDisplayInfo() {
        return gameBoardController.toString();
    }

    public boolean insertGameStartData(StartSettings startSettings) {
        try {
            Player playerO = new Player(startSettings.namePlayerO, Symbol.O);
            Player playerX = new Player(startSettings.namePlayerX, Symbol.X);
            Symbol startSymbol = startSettings.whoStartsFirst;
            players = new Players(playerO, playerX, startSymbol);

            int width = startSettings.boardWidth;
            int height = startSettings.boardHeight;
            BoardData gameBoardData = new BoardData(width, height);

            int howManySymbolsInRowToWin = startSettings.howManySymbolsInARowToWinRound;
            gameBoardController = new BoardController(gameBoardData, howManySymbolsInRowToWin);
            return true;
        }
        catch (Exception e){
            LOGGER.warning("Something went wrong when converting user start data input into data objects");
            return false;
        }
    }

    public RoundState getRoundState() {
        return gameBoardController.getRoundState();
    }

    public boolean tryToInsertNewCoordinates(int userInput, Messenger messenger){
        if (!gameBoardController.tryMarkFieldAndChangeWinnerStateIfNeeded(userInput, players.getCurrentSymbol())) {
            messenger.printf(MessageKeys.youCannotMarkAGameField, userInput);
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
        gameBoardController.prepareNewRound();
    }

    public void addPointsToPlayers() {
        getRoundState().addPointsAccordingRoundFinishedState(players);
    }

    public String gameFinishResult(Messenger messenger) {
        if (isGameFinished())
            return players.showGameFinishedMessage(messenger);
        else
            return messenger.translateKey(MessageKeys.gameInProgress);
    }

    public void printRoundState(Messenger messenger) {
        RoundState roundState = gameBoardController.getRoundState();
        messenger.printf(roundState.getMessageKey(), roundState.getMessageKeyArguments());
    }

    public Symbol getSymbolToPlayNow() {
        Player currentPlayerTurn = players.getCurrentPlayer();
        return currentPlayerTurn.getSymbol();
    }

    public void setCurrentPlayerToOneWhoStartsRound() {
        players.setCurrentPlayerToOneWhoStartsRound();
    }

    public void setWhoStartedLastRoundToOpposite() {
        players.setWhoStartedLastRoundToOpposite();
    }
}
