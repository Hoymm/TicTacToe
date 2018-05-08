package GameState;
import Data.*;

public class GameFinishedState extends Game {
    public GameFinishedState(Data data, Messeger messeger) {
        super(data, messeger);
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
