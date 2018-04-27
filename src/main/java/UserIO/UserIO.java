package UserIO;
import PlayGame.GameState;
import PlayGame.RunningGameState;
import PlayGame.StartGameState;

import java.util.Scanner;

public class UserIO {
    String lastInput = "";
    private Scanner scanner;
    private InputParams inputParams;

    public UserIO(){
        scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner);
    }

    public String getUserInput(GameState gameState) {
        // TODO think about refactor these if's and instance of
        if (gameState instanceof StartGameState)
            lastInput = inputParams.getPlayerNamesAndBoardDataFromUser();
        else if (gameState instanceof RunningGameState) {
            lastInput = inputParams.getCoordsToPutOnBoard();
        }
        return lastInput;
    }

    public String lastUserInput(){
        return lastInput;
    }
}
