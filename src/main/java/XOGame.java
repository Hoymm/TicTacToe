import Data.Data;
import Data.Colors;
import Data.CurGameDataInfo;
import InfoDisplayer.InfoDisplayer;
import PlayGame.GameState;
import PlayGame.StartGameState;
import UserIO.UserIO;

class XOGame {
    private Data data;
    private CurGameDataInfo curDataInfo;
    private InfoDisplayer infoDisplayer;
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
        infoDisplayer = new InfoDisplayer();
        data = new Data();
    }

    void runGame() {
        while (userDontWantLeaveGame()){
            String userParamsInserted = userIO.getParametersFromUser(gameState);
            data.getInputFromUser(userParamsInserted, gameState); // TODO 27.04.2018 Damian why data provides input if there is a UserIO class ????
            infoDisplayer.displayCurGameData(data.displayInfo());
            gameState = gameState.getNextGameState(data.getDataMutator());
        }
    }

    private boolean userDontWantLeaveGame() {
        return !userIO.lastUserInput().equalsIgnoreCase("quit");
    }
}
