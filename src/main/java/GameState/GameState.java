package GameState;

public interface GameState {
    Game getNextState();
    void makeUserToInputData();
    String lastUserInput();
    void displayGame();
}
