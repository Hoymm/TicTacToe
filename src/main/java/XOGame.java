import Data.Colors;
import GameState.*;

class XOGame {
    private GameController gameController;

    XOGame() {
        showInfoAboutGameToTheUser();
        gameController = new StartGameState();
    }

    private void showInfoAboutGameToTheUser() {
        System.out.println("Hello in XO gameController !");
        System.out.println(String.format("Player who moves in the current game is marked %sgreen%s.", Colors.ACTIVE, Colors.DEFAULT));
        System.out.println("To quit game while playing you can type: quit");
    }

    void runGame() {
        while (gameController.userWantsToStayInGame()) {
            if (gameController.tryFetchAndProcessValidInputFromUser())
                gameController = gameController.getNextState();
            gameController.displayGame();
        }
    }
}
