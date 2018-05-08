package Data;
import GameState.UserIO.InputParams;

import java.util.Objects;
import java.util.logging.Logger;

public class Data implements DataMutator{
    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());
    private Players players;
    private BoardController gameBoardController;
    private int roundsPlayed;

    public Data(){
        roundsPlayed = 0;
    }

    public Data(String userInput) {
        insertGameStartData(userInput);
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

    @Override
    public void changePlayerToOpposite() {
        players.changePlayerTurn();
    }

    @Override
    public String gameHeaderDisplayInfo() {
        return players.toString();
    }

    @Override
    public String gameBoardDisplayInfo() {
        return gameBoardController.toString();
    }

    @Override
        public boolean insertGameStartData(String userInput) {
        try {
            String[] userInputArray = userInput.split(InputParams.SEPARATOR);

            Player playerO = new Player(userInputArray[0], Symbol.O);
            Player playerX = new Player(userInputArray[1], Symbol.X);
            Symbol startSymbol = Symbol.valueOf(userInputArray[2]);
            int howManySymbolsInRowToWin = Integer.valueOf(userInputArray[3]);
            int width = Integer.valueOf(userInputArray[4]);
            Integer height = Integer.valueOf(userInputArray[5]);

            players = new Players(playerO, playerX, startSymbol);
            BoardData gameBoardData = new BoardData(width, height);
            gameBoardController = new BoardController(gameBoardData, howManySymbolsInRowToWin);
            return true;
        }
        catch (Exception e){
            LOGGER.warning("Something went wrong when converting user start data input into data objects");
            return false;
        }
    }

    @Override
    public RoundState getRoundState() {
        return gameBoardController.getFinishedState();
    }

    @Override
    public boolean insertNewCoordinates(int userInput){
        if (!gameBoardController.tryMarkFieldAndChangeWinnerStateIfNeeded(userInput, players.getCurrentSymbol())) {
            System.out.println(String.format("You cannot mark \"%d\", please mark free game field.", userInput));
            return false;
        }
        return true;
    }

    @Override
    public void addPointsToPlayer(Symbol symbol) {
        players.addPointsToPlayer(symbol);
    }

    @Override
    public boolean isGameFinished() {
        return roundsPlayed == 3;
    }

    @Override
    public void incrementRoundsPlayed() {
        roundsPlayed++;
    }

    @Override
    public void prepareNewRound() {
        gameBoardController.resetBoard();
        gameBoardController.setRoundStateToUnfinished();
    }

    @Override
    public void addScoresToWinner() {
        switch (getRoundState()){
            case XWon:
                addPointsToPlayer(Symbol.X);
                break;
            case OWon:
                addPointsToPlayer(Symbol.O);
                break;
        }
    }

    @Override
    public String gameFinishResult() {
        if (isGameFinished())
            return players.gameFinishedMessage();
        else
            return "Gra w trakcie";
    }
}
