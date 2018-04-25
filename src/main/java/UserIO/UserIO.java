package UserIO;

import java.util.Scanner;

public class UserIO {
    public String lastInput = "";
    private Scanner scanner;

    public UserIO(){
        scanner = new Scanner(System.in);
    }

    public String userGameStartInput() {
        return "Maciek Wojtek 3 3";
    }

    public void askUserToInputData() {
        lastInput = scanner.nextLine();
    }

    public String lastUserInput(){
        return lastInput;
    }
}
