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
        System.out.println(dataMutator.gameFinishResult());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return false;
    }
}
