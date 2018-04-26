package UserIO;
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
        // TODO think about refactor these if's and instance of
        if (gameState instanceof StartGameState)
            return paramsInput.getPlayerNamesAndBoardDataFromUser();
        else if (gameState instanceof RunningGameState)
            return askUserToInputData();
        return paramsInput.getMove();
    }

    public String askUserToInputData() {
        System.out.println("Insert something: ");
        return scanner.nextLine();
    }

    public String lastUserInput(){
        return lastInput;
    }
}
