package GameState;
import Data.*;
import GameState.UserIO.UserIO;

import static GameState.UserIO.InputParams.QUIT_COMMAND;

public abstract class Game extends UserIO implements GameController {
    protected Data data;

    Game(Data data) {
        this.data = data;
    }

    @Override
    public void displayGame() {
        System.out.println(data.gameHeaderDisplayInfo());
        System.out.println(data.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !lastInput.equalsIgnoreCase(QUIT_COMMAND);
    }
}
