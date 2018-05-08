package GameState;

import Data.Data;

public class RoundFinishedState extends Game {
    public RoundFinishedState(Data data) {
        super(data);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return true;
    }

    @Override
    public Game getNextState() {
        System.out.println(data.getRoundState());
        if (data.isGameFinished()) {
            return new GameFinishedState(data);
        }
        else {
            data.prepareNewRound();
            return new RunningGameState(data);
        }
    }

}
