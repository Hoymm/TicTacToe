package PlayGame;

import Data.CurGameDataMutator;

public class StartGameState implements GameState {
    @Override
    public GameState getNextGameState(CurGameDataMutator dataMutator) {
        return new RunningGameState();
    }
}
