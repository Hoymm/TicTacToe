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
            addScoresIfWinner();
            if (dataMutator.isGameFinished()) {
                displayGame();
                return new GameFinishedState(dataMutator);
            }
            else {
                return new RunningGameState(dataMutator.prepareNewRound());
            }
        }
    }

    private void addScoresIfWinner() {
        switch (dataMutator.getRoundState()){
            case XWon:
                dataMutator.addPointsToPlayer(Symbol.X);
                break;
            case OWon:
                dataMutator.addPointsToPlayer(Symbol.O);
                break;
        }
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && dataMutator.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
