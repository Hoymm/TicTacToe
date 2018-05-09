package GameState;
import Data.Data;
import Data.Messenger;

public class RoundFinishedState extends Game {
    public RoundFinishedState(Data data, Messenger messenger) {
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
