package UserIO;

import java.util.Scanner;

public class InputParams {
    public final static char SEPARATOR = ';';
    private Scanner scanner;

    public InputParams(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getPlayersAndBoardDataFromUser() {
        StringBuilder builderUserInput = new StringBuilder();
        System.out.println("Insert first player name: ");
        builderUserInput.append(scanner.nextLine()).append(SEPARATOR);
        System.out.println("Insert second player name: ");
        builderUserInput.append(scanner.nextLine()).append(SEPARATOR);
        System.out.println("Insert board width: ");
        builderUserInput.append(scanner.nextLine()).append(SEPARATOR);
        System.out.println("Insert board height: ");
        builderUserInput.append(scanner.nextLine()).append(SEPARATOR);
        return builderUserInput.toString();
    }
}
