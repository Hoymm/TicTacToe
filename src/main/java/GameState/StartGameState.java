package GameState;
import Data.*;

public class StartGameState extends Game {

    public StartGameState(Messenger messenger) {
        super(new Data(messenger), messenger);
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(data, messenger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        return data.insertGameStartData(lastInput);
    }
}
