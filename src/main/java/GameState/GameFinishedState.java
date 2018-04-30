package GameState;

import Data.Data;

public class GameFinishedState extends Game {
    public GameFinishedState(Data data) {
        super(data);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return false;
    }

    @Override
    public Game getNextState() {
        return null;
    }
}
