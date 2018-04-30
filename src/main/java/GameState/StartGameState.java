package GameState;

import Data.Data;

public class StartGameState extends Game {
    public StartGameState() {
        super(new Data());
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(data);
    }

    @Override
    public boolean tryPossessAndProcessValidInputFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        return data.insertGameStartData(lastInput);
    }
}
