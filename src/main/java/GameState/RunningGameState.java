package GameState;

import Data.Data;

public class RunningGameState extends Game implements GameState {
    RunningGameState(Data data) {
        super(data);
    }

    @Override
    public Game getNextState() {
        data.getDataMutator().changePlayerToOpposite();
        return this;
    }

    @Override
    public void makeUserToInputData() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        data.insertNewCoordinates(lastInput);
    }
}
