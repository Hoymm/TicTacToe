package PlayGame;

public class RunningGameState implements GameState {
    @Override
    public GameState moveToNextState() {
        return this;
    }
}
