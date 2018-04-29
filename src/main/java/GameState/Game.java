package GameState;

import Data.Data;
import GameState.UserIO.UserIO;

public abstract class Game extends UserIO implements GameState {
    protected Data data;

    public Game(Data data) {
        this.data = data;
    }

    public void displayGame() {
        System.out.println(data.gameHeaderDisplayInfo());
        System.out.println(data.gameBoardDisplayInfo());
    }

    public String lastUserInput() {
        return lastInput;
    }
}
