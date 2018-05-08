package GameState;
import Data.*;

public class GameFinishedState extends Game {
    public GameFinishedState(DataMutator dataMutator) {
        super(dataMutator);
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
        finishMessageToTheUser.append(dataMutator.getRoundState().toString());
        finishMessageToTheUser.append(". ");
        finishMessageToTheUser.append(dataMutator.getGameScores());
        System.out.println(finishMessageToTheUser.toString());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return false;
    }
}
