package GameState.UserIO;

import java.util.Scanner;

public abstract class UserIO {
    public String lastInput = "";
    private Scanner scanner;
    public InputParams inputParams;

    public UserIO(){
        scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner);
    }

    public String lastUserInput(){
        return lastInput;
    }
}
