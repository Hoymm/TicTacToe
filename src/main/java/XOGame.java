import Data.Colors;
import GameState.*;

class XOGame {
    private Game game;

    XOGame() {
        showInfoAboutGameToTheUser();
        initGameStartConditions();
    }

    private void showInfoAboutGameToTheUser() {
        System.out.println("Hello in XO game !");
        System.out.println(String.format("Player who moves in the current game is marked %sgreen%s.", Colors.ACTIVE, Colors.DEFAULT));
        System.out.println("To quit game while playing you can type: quit");
    }

    private void initGameStartConditions() {
        game = new StartGameState();
    }

    void runGame() {
        while (userDontWantLeaveGame()){
            game.makeUserToInputData();
            game = game.getNextState();
            game.displayGame();
        }
    }

    private boolean userDontWantLeaveGame() {
        return !game.lastUserInput().equalsIgnoreCase("quit");
    }
}
