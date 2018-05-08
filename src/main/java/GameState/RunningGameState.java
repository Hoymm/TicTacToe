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
            dataMutator.addScoresToWinner();
            displayGame();
            if (dataMutator.isGameFinished()) {
                return new GameFinishedState(dataMutator);
            }
            else {
                System.out.println(dataMutator.getRoundState());
                dataMutator.prepareNewRound();
            }
        }
        return this;
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        lastInput = inputParams.getCoordsToPutOnBoard();
        return userWantsToStayInGame() && dataMutator.insertNewCoordinates(Integer.valueOf(lastInput));
    }
}
