package PlayGame;

public class RunningGameState implements GameState {
    @Override
    public GameState getNextGameState() {
        return this;
    }
}
