package GameState;
import Data.Data;
import Data.Messeger;
import GameState.UserIO.UserIO;

public abstract class Game extends UserIO implements GameController {
    protected Data data;

    Game(Data data, Messeger messeger) {
        super(messeger);
        this.data = data;
    }

    @Override
    public void displayGame() {
        messeger.print(data.gameHeaderDisplayInfo());
        messeger.print(data.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !lastInput.equalsIgnoreCase(inputParams.getQuitCommand());
    }
}
