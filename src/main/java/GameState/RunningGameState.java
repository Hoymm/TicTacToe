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
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
