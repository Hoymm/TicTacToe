package GameState;

import Data.*;

public class RunningGameState extends Game {
    RunningGameState(Data data) {
        super(data);
    }

    @Override
    public Game getNextState() {
        if (data.getGameFinishedState() == FinishState.NotFinished) {
            data.getDataMutator().changePlayerToOpposite();
            return this;
        }
        else {
            displayGame();
            return new GameFinishedState(data);
        }
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
