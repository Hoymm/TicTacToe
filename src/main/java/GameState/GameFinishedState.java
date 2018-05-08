package GameState;
import Data.*;

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
        System.out.println(data.gameFinishResult());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return false;
    }
}
