package GameState;

import Data.Data;

public class RunningGameState extends Game {
    RunningGameState(Data data) {
        super(data);
    }

    @Override
    public Game getNextState() {
        data.getDataMutator().changePlayerToOpposite();
        return this;
    }

    @Override
    public boolean tryPossessAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
