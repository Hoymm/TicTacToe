package gameState;

import messenger.Messenger;

public interface GameController {
    void displayGame(Messenger messenger);
    boolean userWantsToStayInGame();
    boolean tryFetchAndProcessValidInputFromUser();
    Game getNextState();
}
