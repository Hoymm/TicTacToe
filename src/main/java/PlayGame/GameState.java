package PlayGame;

import Data.CurGameDataMutator;

public interface GameState {
    GameState getNextState(CurGameDataMutator dataMutator);
}
