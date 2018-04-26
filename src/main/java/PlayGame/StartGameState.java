package PlayGame;

public class StartGameState implements GameState {
    @Override
    public GameState moveToNextState() {
        return new RunningGameState();
    }
}
