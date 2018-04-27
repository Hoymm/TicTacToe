package GameState;

import Data.CurGameDataMutator;
import GameState.UserIO.UserIO;

public class RunningGameState extends UserIO implements GameState {
    @Override
    public GameState getNextState(CurGameDataMutator dataMutator) {
        dataMutator.changePlayerToOpposite();
        return this;
    }

    @Override
    public String getNewInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return lastInput;
    }

    @Override
    public String lastUserInput() {
        return lastInput;
    }
}
