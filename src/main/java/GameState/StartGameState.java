package GameState;

import Data.CurGameDataMutator;
import GameState.UserIO.UserIO;

public class StartGameState extends UserIO implements GameState {
    @Override
    public GameState getNextState(CurGameDataMutator dataMutator) {
        return new RunningGameState();
    }

    @Override
    public String getNewInputFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        return lastInput;
    }

    @Override
    public String lastUserInput() {
        return lastInput;
    }
}
