package gameState.states;
import data.*;
import messenger.Messenger;
import gameState.Game;
import gameState.userIO.startSettingsInput.StartSettings;

public class StartGameState extends Game {

    public StartGameState(Messenger messenger) {
        super(new Data(), messenger);
    }

    @Override
    public Game getNextState() {
        return new RunningGameState(data, messenger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        StartSettings startSettings = userIO.loadAndReturnStartSettingsFromUser();
        return data.insertGameStartData(startSettings);
    }
}
