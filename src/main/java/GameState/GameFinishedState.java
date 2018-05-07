package GameState;
import Data.Data;

public class GameFinishedState extends Game {
    public GameFinishedState(Data data) {
        super(data);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return false;
    }

    @Override
    public Game getNextState() {
        return null;
    }

    @Override
    public void displayGame() {
        StringBuilder finishMessageToTheUser = new StringBuilder();
        finishMessageToTheUser.append(data.getGameFinishedState().toString());
        finishMessageToTheUser.append(". ");
        finishMessageToTheUser.append(data.getGameScores());
        System.out.println(finishMessageToTheUser.toString());
    }
}
