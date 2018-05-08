package GameState;

import Data.DataMutator;

public class RoundFinishedState extends Game {
    public RoundFinishedState(DataMutator dataMutator) {
        super(dataMutator);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return true;
    }

    @Override
    public Game getNextState() {
        dataMutator.addScoresToWinner();
        System.out.println(dataMutator.getRoundState());
        if (dataMutator.isGameFinished()) {
            return new GameFinishedState(dataMutator);
        }
        else {
            dataMutator.prepareNewRound();
            return new RunningGameState(dataMutator);
        }
    }

}
