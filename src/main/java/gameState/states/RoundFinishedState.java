package gameState.states;
import data.Data;
import messenger.Messenger;
import gameState.Game;

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
        data.printRoundState(messenger);
        if (data.isGameFinished()) {
            return new GameFinishedState(data, messenger);
        }
        else {
            data.prepareNewRound();
            return new RunningGameState(data, messenger);
        }
    }
}
