package UserIO;
import Data.Data;
import PlayGame.GameState;
import PlayGame.RunningGameState;
import PlayGame.StartGameState;

import java.util.Scanner;

public class UserIO {
    String lastInput = "";
    private Scanner scanner;
    private InputParams paramsInput;

    public UserIO(){
        scanner = new Scanner(System.in);
        paramsInput = new InputParams(scanner);
    }

    public String getParametersFromUser(GameState gameState) {
        if (gameState instanceof StartGameState)
            return paramsInput.getPlayerNamesAndBoardDataFromUser();
        else // TODO change that else
            return "X";
    }

    public void askUserToInputData() {
        System.out.println("Insert something: ");
        lastInput = scanner.nextLine();
    }

    public String lastUserInput(){
        return lastInput;
    }
}
