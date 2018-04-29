package GameState;

public interface GameController {
    void displayGame();
    boolean userWantsToStayInGame();
    void makeUserToInputData();
    Game getNextState();
}
