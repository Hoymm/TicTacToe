package Data;
import GameState.UserIO.InputParams;

import java.util.Objects;
import java.util.logging.Logger;

public class Data {
    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());
    private Players players;
    private BoardController gameBoard;

    public Data(){
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

        return Objects.hash(players, gameBoard);
    }

    public String gameHeaderDisplayInfo() {
        return players.toString();
    }

    public String gameBoardDisplayInfo() {
        return gameBoard.toString();
    }

    public CurGameDataMutator getDataMutator(){
        return new CurGameDataMutator() {
            @Override
            public void changePlayerToOpposite() {
                players.changePlayerTurn();
            }
        };
    }

    public boolean insertGameStartData(String userInput) {
        try {
            String[] userInputArray = userInput.split(InputParams.SEPARATOR);
            this.players = new Players(new Player(userInputArray[0], Symbol.O), new Player(userInputArray[1], Symbol.X), Symbol.valueOf(userInputArray[2]));
            BoardData gameBoardData = new BoardData(Integer.valueOf(userInputArray[3]), Integer.valueOf(userInputArray[4]));
            this.gameBoard = new BoardController( gameBoardData,3);
            return true;
        }
        catch (Exception e){
            LOGGER.warning("Something went wrong when converting user start data input into data objects");
            return false;
        }
    }

    public boolean insertNewCoordinates(int userInput){
        if (!gameBoard.tryMarkFieldAndChangeWinnerStateIfNeeded(userInput, players.getCurrentSymbol())) {
            System.out.println(String.format("You cannot mark \"%d\", please mark free game field.", userInput));
            return false;
        }
        return true;
    }

    public FinishState getGameFinishedState() {
        return gameBoard.getFinishedState();
    }

    public String getGameScores() {
        return "";
    }
}
