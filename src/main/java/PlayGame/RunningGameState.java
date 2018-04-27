package PlayGame;

import Data.CurGameDataMutator;

public class RunningGameState implements GameState {
    @Override
    public GameState getNextGameState(CurGameDataMutator dataMutator) {
        dataMutator.changePlayerToOpposite();
        return this;
    }
}
