package GameState.States;
import Data.*;
import Data.Messenger.Messenger;
import GameState.Game;

public class StartGameState extends Game {

    public StartGameState(Messenger messenger) {
        super(new Data(messenger), messenger);
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(data, messenger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        userIO.loadGameSettingsFromUser();
        return data.insertGameStartData(userIO.getLastInput());
    }
}
