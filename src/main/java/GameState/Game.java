package GameState;
import Data.Data;
import Data.Messenger;
import GameState.UserIO.UserIO;

public abstract class Game extends UserIO implements GameController {
    protected Data data;

    Game(Data data, Messenger messenger) {
        super(messenger);
        this.data = data;
    }

    @Override
    public void displayGame() {
        messenger.print(data.gameHeaderDisplayInfo());
        messenger.print(data.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !lastInput.equalsIgnoreCase(inputParams.getQuitCommand());
    }
}
