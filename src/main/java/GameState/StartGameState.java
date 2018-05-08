package GameState;
import Data.*;

public class StartGameState extends Game {
    public StartGameState() {
        super((DataMutator)new Data());
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(dataMutator);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        return dataMutator.insertGameStartData(lastInput);
    }
}
