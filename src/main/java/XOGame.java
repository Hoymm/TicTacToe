import Data.Colors;
import Data.Message;
import Data.Speaker;
import GameState.*;

import java.util.Locale;

import static GameState.UserIO.InputParams.QUIT_COMMAND;

class XOGame {
    private GameController gameController;
    private Speaker journalist;

    XOGame() {
        Locale PL = new Locale("pl", "PL");
        Locale ENG = Locale.ENGLISH;
        journalist = new Speaker(PL, System.out::println);
        showInfoAboutGameToTheUser();
        gameController = new StartGameState();
    }

    private void showInfoAboutGameToTheUser() {
        journalist.printOutputViaKey(Message.hello);
        System.out.printf("Hello in XO gameController !\nPlayer who moves in the current game is marked %sgreen%s.\nTo quit game while playing you can type: %s", Colors.ACTIVE, Colors.DEFAULT, QUIT_COMMAND);
    }

    void runGame() {
        while (gameController.userWantsToStayInGame()) {
            if (gameController.tryFetchAndProcessValidInputFromUser()) {
                gameController = gameController.getNextState();
                gameController.displayGame();
            }
        }
        System.out.println("Bye bye, come back to me later ! : )");
    }
}
