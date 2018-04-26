package UserIO;

import java.util.Scanner;

public class UserIO {
    public String lastInput = "";
    private Scanner scanner;
    private InputParams paramsGetter;
    private InputParamsValidator inputParamsValidator;

    public UserIO(){
        scanner = new Scanner(System.in);
        paramsGetter = new InputParams(scanner);
        inputParamsValidator = new InputParamsValidator();
    }

    public String getStartGameParametersFromUser() {
        return paramsGetter.getPlayersAndBoardDataFromUser();
    }

    public void askUserToInputData() {
        System.out.println("Insert something: ");
        lastInput = scanner.nextLine();
    }

    public String lastUserInput(){
        return lastInput;
    }
}
