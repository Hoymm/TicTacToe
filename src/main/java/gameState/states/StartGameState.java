package gameState.states;
import data.*;
import data.messenger.Messenger;
import gameState.Game;

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
