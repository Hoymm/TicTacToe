package GameState.States;
import Data.*;
import Data.Messenger.Messenger;
import GameState.Game;

public class GameFinishedState extends Game {
    GameFinishedState(Data data, Messenger messenger) {
        super(data, messenger);
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
