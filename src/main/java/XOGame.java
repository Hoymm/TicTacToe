import Data.Data;
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
        System.out.println("To quit game any moment you can type: quit");
    }

    private void initGameStartConditions() {
        gameState = new StartGameState();
        userIO = new UserIO();
        infoDisplayer = new InfoDisplayer();
    }

    void runGame() {
        while (userDontWantLeaveGame()){
            String userParamsInserted = userIO.getParametersFromUser(gameState);
            data = new Data(userParamsInserted);
            curDataInfo = data.displayInfo();
            infoDisplayer.displayCurGameData(curDataInfo);
            userIO.askUserToInputData();
        }
    }

    private boolean userDontWantLeaveGame() {
        return !userIO.lastUserInput().equalsIgnoreCase("quit");
    }
}
