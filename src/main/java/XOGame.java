import Data.Colors;
import Data.MessageKeys;
import Data.Messeger;
import GameState.GameController;
import GameState.StartGameState;
import java.util.Locale;

class XOGame {
    private GameController gameController;
    private Messeger messeger;

    XOGame() {
        Locale PL = new Locale("pl", "PL");
        Locale ENG = Locale.ENGLISH;
        messeger = new Messeger(PL, System.out::println);
        showInfoAboutGameToTheUser();
        gameController = new StartGameState(messeger);
    }

    private void showInfoAboutGameToTheUser() {
        messeger.print(MessageKeys.startInfoAboutGame, Colors.ACTIVE, Colors.DEFAULT);
    }

    void runGame() {
        while (gameController.userWantsToStayInGame()) {
            if (gameController.tryFetchAndProcessValidInputFromUser()) {
                gameController = gameController.getNextState();
                gameController.displayGame();
            }
        }
        messeger.print(MessageKeys.farewell);
    }
}
