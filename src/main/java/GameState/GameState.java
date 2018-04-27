package GameState;

import Data.CurGameDataMutator;

public interface GameState {
    GameState getNextState(CurGameDataMutator dataMutator);
    String getNewInputFromUser();
    String lastUserInput();
}
