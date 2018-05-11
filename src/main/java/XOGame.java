import Data.Colors;
import Data.Messenger.MessageKeys;
import Data.Messenger.Messenger;
import GameState.GameController;
import GameState.States.StartGameState;
import java.util.Locale;

class XOGame {
    private GameController gameController;
    private Messenger messenger;

    XOGame() {
        Locale PL = new Locale("pl", "PL");
        Locale ENG = Locale.ENGLISH;
        messenger = new Messenger(PL, System.out::println);
        showInfoAboutGameToTheUser();
        gameController = new StartGameState(messenger);
    }

    private void showInfoAboutGameToTheUser() {
        messenger.print(MessageKeys.startInfoAboutGame, Colors.ACTIVE, Colors.DEFAULT);
    }

    void runGame() {
        while (gameController.userWantsToStayInGame()) {
            if (gameController.tryFetchAndProcessValidInputFromUser()) {
                gameController = gameController.getNextState();
                gameController.displayGame();
            }
        }
        messenger.print(MessageKeys.farewell);
    }
}
