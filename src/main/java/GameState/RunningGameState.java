package GameState;

import Data.Data;
import Data.FinishedChecker.FinishStates;

public class RunningGameState extends Game {
    RunningGameState(Data data) {
        super(data);
    }

    @Override
    public Game getNextState() {
        if (data.getGameFinishedState() == FinishStates.NotFinished) {
            data.getDataMutator().changePlayerToOpposite();
            return this;
        }
        else {
            return new GameFinishedState(data);
        }
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
