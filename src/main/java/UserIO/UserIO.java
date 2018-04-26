package UserIO;

import java.util.Scanner;

public class UserIO {
    public String lastInput = "";
    private Scanner scanner;
    private InputParams paramsGetter;

    public UserIO(){
        scanner = new Scanner(System.in);
        paramsGetter = new InputParams(scanner);
    }

    public String getStartGameParametersFromUser() {
        return paramsGetter.getPlayerNamesAndBoardDataFromUser();
    }

    public void askUserToInputData() {
        System.out.println("Insert something: ");
        lastInput = scanner.nextLine();
    }

    public String lastUserInput(){
        return lastInput;
    }
}
