package PlayGame;

import Data.CurGameDataMutator;

public class RunningGameState implements GameState {
    @Override
    public GameState getNextState(CurGameDataMutator dataMutator) {
        dataMutator.changePlayerToOpposite();
        return this;
    }
}
