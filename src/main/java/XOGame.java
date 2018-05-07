import Data.Colors;
import GameState.*;

import static GameState.UserIO.InputParams.QUIT_COMMAND;

class XOGame {
    private GameController gameController;

    XOGame() {
        showInfoAboutGameToTheUser();
        gameController = new StartGameState();
    }

    private void showInfoAboutGameToTheUser() {
        System.out.println("Hello in XO gameController !");
        System.out.println(String.format("Player who moves in the current game is marked %sgreen%s.", Colors.ACTIVE, Colors.DEFAULT));
        System.out.println(String.format("To quit game while playing you can type: %s", QUIT_COMMAND));
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
