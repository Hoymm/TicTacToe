package GameState.UserIO;

import java.util.Scanner;

public abstract class UserIO {
    protected String lastInput = "";
    protected InputParams inputParams;

    protected UserIO(){
        Scanner scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner);
    }
}
