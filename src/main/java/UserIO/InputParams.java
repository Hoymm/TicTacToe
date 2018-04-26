package UserIO;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputParams {
    static final Logger LOGGER = Logger.getLogger(InputParams.class.getName());
    private InputParamsValidator inputParamsValidator;
    public final static char SEPARATOR = ';';
    private Scanner scanner;

    InputParams(Scanner scanner) {
        this.scanner = scanner;
        inputParamsValidator = new InputParamsValidator();
    }

    String getPlayerNamesAndBoardDataFromUser() {
        StringBuilder builderUserInput = new StringBuilder();
        builderUserInput.append(insertAndValidatePlayerName("Insert first player name: ")).append(SEPARATOR);
        builderUserInput.append(insertAndValidatePlayerName("Insert second player name: ")).append(SEPARATOR);
        builderUserInput.append(insertAndValidateTableParam("width")).append(SEPARATOR);
        builderUserInput.append(insertAndValidateTableParam("height"));
        return builderUserInput.toString();
    }

    private String insertAndValidatePlayerName(String message) {
        String playerName = "";
        boolean validationPassed = false;
        while (!validationPassed){
            System.out.println(message);
            try {
                playerName = scanner.nextLine();
                validationPassed = inputParamsValidator.validateInsertedName(playerName);
            } catch (InputCannotBeEmptyException e) {
                LOGGER.warning("User tried to insert empty name");
            }
            if (!validationPassed)
                System.out.println(String.format("Name should contain only letters. \"%s\" is not acceptable name.", playerName));
        }
        return playerName;
    }

    private int insertAndValidateTableParam(String paramToGet) {
        String tableParameter = "";
        while(!inputParamsValidator.isTableParamVaild(tableParameter)){
            System.out.println(String.format("Insert board %s: ", paramToGet));
            tableParameter = scanner.nextLine();
            if (!inputParamsValidator.isTableParamVaild(tableParameter))
                System.out.println(String.format("Please insert integer value, greater or equal 3. \n \"%s\" is not acceptable table %s"
                        , tableParameter, paramToGet));
        }
        return Integer.valueOf(tableParameter);
    }

}
