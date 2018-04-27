package PlayGame;

import Data.CurGameDataMutator;

public interface GameState {
    GameState getNextGameState(CurGameDataMutator dataMutator);
}
