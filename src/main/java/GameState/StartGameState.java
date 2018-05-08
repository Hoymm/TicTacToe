package GameState;
import Data.*;

public class StartGameState extends Game {

    public StartGameState(Messeger messeger) {
        super(new Data(), messeger);
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(data, messeger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        return data.insertGameStartData(lastInput);
    }
}
