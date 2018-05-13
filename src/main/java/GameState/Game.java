package GameState;
import Data.Data;
import Data.Messenger.Messenger;
import GameState.UserIO.UserIO;

public abstract class Game implements GameController {
    protected Data data;
    protected UserIO userIO;
    protected Messenger messenger;

    public Game(Data data, Messenger messenger) {
        userIO = new UserIO(messenger);
        this.data = data;
        this.messenger = messenger;
    }

    @Override
    public void displayGame() {
        messenger.printf(data.gameHeaderDisplayInfo());
        messenger.printf(data.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !userIO.wasALastInputAQuitCommand();
    }
}
