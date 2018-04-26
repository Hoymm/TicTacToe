import Data.Data;
import Data.CurGameStateInfo;
import InfoDisplayer.InfoDisplayer;
import UserIO.UserIO;

public class XOGame {
    private Data data;
    private CurGameStateInfo curGameState;
    private InfoDisplayer infoDisplayer;
    private UserIO userIO;

    public XOGame() {
        showInfoAboutGameToTheUser();
        initGameStartConditions();
    }

    private void showInfoAboutGameToTheUser() {
        System.out.println("To quit game any moment you can type ");
    }

    private void initGameStartConditions() {
        userIO = new UserIO();
        data = provideGameSettingsData();
        curGameState = data.displayInfo();
        infoDisplayer = new InfoDisplayer();
    }

    private Data provideGameSettingsData() {
        return new Data(userIO.getStartGameParametersFromUser());
    }

    public void runGame() {
        while (userDontWantLeaveGame()){
            infoDisplayer.displayCurGameState(curGameState);
            userIO.askUserToInputData();
        }
    }

    private boolean userDontWantLeaveGame() {
        return !userIO.lastUserInput().equalsIgnoreCase("quit");
    }
}
