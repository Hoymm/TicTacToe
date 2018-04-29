package GameState;

import Data.Data;
import GameState.UserIO.UserIO;

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
        return !lastInput.equalsIgnoreCase("quit");
    }
}
