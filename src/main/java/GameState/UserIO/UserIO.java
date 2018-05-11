package GameState.UserIO;

import Data.Messenger.Messenger;

import java.util.Scanner;

public abstract class UserIO {
    protected String lastInput = "";
    protected InputParams inputParams;
    protected Messenger messenger;

    protected UserIO(Messenger messenger){
        this.messenger = messenger;
        Scanner scanner = new Scanner(System.in);
        inputParams = new InputParams(scanner, messenger);

    }
}
