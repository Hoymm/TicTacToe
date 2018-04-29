package GameState.UserIO;

import java.util.Scanner;

public abstract class UserIO {
    protected String lastInput = "";
    private Scanner scanner;
    protected InputParams inputParams;

    protected UserIO(){
        scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner);
    }
}
