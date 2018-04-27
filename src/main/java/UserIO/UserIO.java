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
            lastInput = paramsInput.getPlayerNamesAndBoardDataFromUser();
        else if (gameState instanceof RunningGameState) {

            lastInput = paramsInput.getCoordsToPutOnBoard();
        }
        return lastInput;
    }

    public String lastUserInput(){
        return lastInput;
    }
}
