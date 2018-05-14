package gameState;
import data.Data;
import data.messenger.Messenger;
import gameState.userIO.UserIO;

public abstract class Game implements GameController {
    final protected Data data;
    final protected UserIO userIO;
    final protected Messenger messenger;

    protected Game(Data data, Messenger messenger) {
        userIO = new UserIO(messenger);
        this.data = data;
        this.messenger = messenger;
    }

    @Override
    public void displayGame(Messenger messenger) {
        messenger.printf(data.gameHeaderDisplayInfo());
        messenger.printf(data.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !userIO.wasALastInputAQuitCommand();
    }
}
