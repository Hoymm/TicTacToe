package GameState;

import Data.*;

public class RunningGameState extends Game {
    RunningGameState(Data data, Messeger messeger) {
        super(data, messeger);
    }

    @Override
    public Game getNextState() {
        data.changePlayerToOpposite();
        if (data.getRoundState() != RoundState.Unfinished) {
            data.incrementRoundsPlayed();
            data.addNewPointsToPlayers();
            return new RoundFinishedState(data, messeger);
        }
        return this;
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
