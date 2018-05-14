package gameState.userIO;
import messenger.Messenger;
import gameState.userIO.startSettingsInput.StartSettings;

import java.util.Scanner;

public class UserIO {
    private String lastInput = "";
    private final UserInputHandler userInputHandler;

    public UserIO(Messenger messenger){
        userInputHandler = new UserInputHandler(new Scanner(System.in)::nextLine, messenger);
    }

    public boolean wasALastInputAQuitCommand() {
        return lastInput.equalsIgnoreCase(userInputHandler.getQuitCommand());
    }

    public StartSettings loadAndReturnStartSettingsFromUser() {
        return userInputHandler.getStartSettings();
    }

    public void loadFromUserFieldNumberOnBoardToPutSymbol() {
        lastInput = userInputHandler.getCoordsToPutOnBoard();
    }

    public String getLastInput() {
        return lastInput;
    }
}
