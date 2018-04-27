import Data.Data;
import Data.Colors;
import Data.CurGameDataInfo;
import InfoDisplayer.GameDisplayer;
import PlayGame.GameState;
import PlayGame.StartGameState;
import UserIO.UserIO;

class XOGame {
    private Data data;
    private CurGameDataInfo curDataInfo;
    private GameDisplayer gameDisplayer;
    private UserIO userIO;
    private GameState gameState;

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
        gameState = new StartGameState();
        userIO = new UserIO();
        gameDisplayer = new GameDisplayer();
        data = new Data();
    }

    void runGame() {
        while (userDontWantLeaveGame()){
            String userInput = userIO.getUserInput(gameState);
            data.applyUserInput(userInput, gameState); // TODO 27.04.2018 Damian why data provides input if there is a UserIO class ????
            gameDisplayer.display(data.getInfoToDisplay());
            gameState = gameState.getNextState(data.getDataMutator());
        }
    }

    private boolean userDontWantLeaveGame() {
        return !userIO.lastUserInput().equalsIgnoreCase("quit");
    }
}
