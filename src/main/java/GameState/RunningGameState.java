package GameState;

import Data.*;

public class RunningGameState extends Game {
    RunningGameState(DataMutator dataMutator) {
        super(dataMutator);
    }

    @Override
    public Game getNextState() {
        dataMutator.changePlayerToOpposite();
        if (dataMutator.getRoundState() != RoundState.Unfinished) {
            dataMutator.incrementRoundsPlayed();
            dataMutator.addNewPointsToPlayers();
            return new RoundFinishedState(dataMutator);
        }
        return this;
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && dataMutator.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
