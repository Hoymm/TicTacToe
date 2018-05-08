package GameState.UserIO;

import Data.Messeger;

import java.util.Scanner;

public abstract class UserIO {
    protected String lastInput = "";
    protected InputParams inputParams;
    protected Messeger messeger;

    protected UserIO(Messeger messeger){
        this.messeger = messeger;
        Scanner scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner, messeger);

    }
}
