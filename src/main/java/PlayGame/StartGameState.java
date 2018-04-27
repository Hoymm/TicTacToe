package PlayGame;

public class StartGameState implements GameState {
    @Override
    public GameState getNextGameState() {
        return new RunningGameState();
    }
}
