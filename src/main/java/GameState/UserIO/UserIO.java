package GameState.UserIO;

import Data.Messenger.Messenger;

import java.util.Scanner;

public class UserIO {
    private String lastInput = "";
    private InputParams inputParams;

    public UserIO(Messenger messenger){
        Scanner scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner, messenger);
    }

    public boolean wasALastInputAQuitCommand() {
        return lastInput.equalsIgnoreCase(inputParams.getQuitCommand());
    }

    public void loadGameSettingsFromUser() {
        lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
    }

    public void loadFromUserFieldNumberOnBoardToPutSymbol() {
        lastInput = inputParams.getCoordsToPutOnBoard();
    }

    public String getLastInput() {
        return lastInput;
    }
}
