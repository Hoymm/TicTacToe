package PlayGame;

import Data.CurGameDataMutator;

public class StartGameState implements GameState {
    @Override
    public GameState getNextState(CurGameDataMutator dataMutator) {
        return new RunningGameState();
    }
}
