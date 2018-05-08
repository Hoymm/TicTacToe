package GameState;
import Data.*;
import GameState.UserIO.UserIO;

import static GameState.UserIO.InputParams.QUIT_COMMAND;

public abstract class Game extends UserIO implements GameController {
    protected DataMutator dataMutator;

    Game(DataMutator dataMutator) {
        this.dataMutator = dataMutator;
    }

    @Override
    public void displayGame() {
        System.out.println(dataMutator.gameHeaderDisplayInfo());
        System.out.println(dataMutator.gameBoardDisplayInfo());
    }

    @Override
    public boolean userWantsToStayInGame() {
        return !lastInput.equalsIgnoreCase(QUIT_COMMAND);
    }
}
