package GameState;

public interface GameController {
    void displayGame();
    boolean userWantsToStayInGame();
    boolean tryPossessAndProcessValidInputFromUser();
    Game getNextState();
}
