import Data.Data;
import Data.Colors;
import Data.CurGameDataInfo;
import InfoDisplayer.GameDisplayer;
import GameState.GameState;
import GameState.*;

class XOGame {
    private Data data;
    private CurGameDataInfo curDataInfo;
    private GameDisplayer gameDisplayer;
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
        // TODO uncomment to start providing  params, and change new Data(...) below to new Data()
        // gameState = new StartGameState();
        gameState = new RunningGameState();
        gameDisplayer = new GameDisplayer();
        data = new Data("Maciek Bolek O 7 12");
    }

    void runGame() {
        while (userDontWantLeaveGame()){
            String userInput = gameState.getNewInputFromUser();
            data.applyUserInput(userInput, gameState); // TODO 27.04.2018 Damian why data provides input if there is a GameState.UserIO class ????
            gameState = gameState.getNextState(data.getDataMutator());
            gameDisplayer.display(data.getInfoToDisplay());
        }
    }

    private boolean userDontWantLeaveGame() {
        return !gameState.lastUserInput().equalsIgnoreCase("quit");
    }
}
