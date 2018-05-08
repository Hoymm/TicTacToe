package GameState;

import Data.*;

public class RunningGameState extends Game {
    RunningGameState(DataMutator dataMutator) {
        super(dataMutator);
    }

    @Override
    public Game getNextState() {
        if (dataMutator.getRoundState() == RoundState.NotFinished) {
            dataMutator.changePlayerToOpposite();
            return this;
        }
        else {
            // runda zakonczona, przyznaj punkty zwyciescy i rozpocznij nową rundę lub zakończ grę
            dataMutator.addPointsToPlayer();
            if (dataMutator.isGameFinished()) {
                displayGame();
                return new GameFinishedState(dataMutator);
            }
            return new GameFinishedState(dataMutator);
        }
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && dataMutator.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
