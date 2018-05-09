package GameState;

import Data.*;

public class RunningGameState extends Game {
    RunningGameState(Data data, Messenger messenger) {
        super(data, messenger);
    }

    @Override
    public Game getNextState() {
        data.changePlayerToOpposite();
        if (data.getRoundState() != RoundState.Unfinished) {
            data.incrementRoundsPlayed();
            data.addNewPointsToPlayers();
            return new RoundFinishedState(data, messenger);
        }
        return this;
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && data.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
