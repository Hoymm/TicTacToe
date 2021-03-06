import data.Colors;
import messenger.MessageKeys;
import messenger.Messenger;
import gameState.GameController;
import gameState.states.StartGameState;

import java.util.Locale;

class XOGame {
    private GameController gameController;
    private final Messenger messenger;

    XOGame(Locale language) {
        messenger = new Messenger(language, System.out::println);
        showInfoAboutGameToTheUser();
        gameController = new StartGameState(messenger);
    }

    private void showInfoAboutGameToTheUser() {
        messenger.printf(MessageKeys.startInfoAboutGame, Colors.ACTIVE, Colors.DEFAULT, messenger.translateKey(MessageKeys.quit));
    }

    void runGame() {
        while (gameController.userWantsToStayInGame()) {
            if (gameController.tryFetchAndProcessValidInputFromUser()) {
                gameController = gameController.getNextState();
                gameController.displayGame(messenger);
            }
        }
        messenger.printf(MessageKeys.farewell);
    }
}
