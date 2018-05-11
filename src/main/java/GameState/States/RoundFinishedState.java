package GameState.States;
import Data.Data;
import Data.Messenger.Messenger;
import GameState.Game;

public class RoundFinishedState extends Game {
    RoundFinishedState(Data data, Messenger messenger) {
        super(data, messenger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return true;
    }

    @Override
    public Game getNextState() {
        data.printRoundState();
        if (data.isGameFinished()) {
            return new GameFinishedState(data, messenger);
        }
        else {
            data.prepareNewRound();
            return new RunningGameState(data, messenger);
        }
    }

}
