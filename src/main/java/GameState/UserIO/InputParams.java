package GameState.UserIO;

import Data.Symbol;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputParams {
    static final Logger LOGGER = Logger.getLogger(InputParams.class.getName());
    private InputParamsValidator inputParamsValidator;
    public final static String SEPARATOR = " ";
    private Scanner scanner;

    InputParams(Scanner scanner) {
        this.scanner = scanner;
        inputParamsValidator = new InputParamsValidator();
    }

    public String getPlayerNamesAndBoardDataFromUser() {
        StringBuilder builderUserInput = new StringBuilder();
        builderUserInput.append(insertAndValidatePlayerName(Symbol.O.toString())).append(SEPARATOR);
        builderUserInput.append(insertAndValidatePlayerName(Symbol.X.toString())).append(SEPARATOR);
        builderUserInput.append(whoStartsFirst()).append(SEPARATOR);
        builderUserInput.append(insertAndValidateTableParam("width")).append(SEPARATOR);
        builderUserInput.append(insertAndValidateTableParam("height"));
        return builderUserInput.toString();
    }

    private String insertAndValidatePlayerName(String player) {
        String playerName = "";
        boolean validationPassed = false;
        while (!validationPassed){
            System.out.println(String.format("Insert %s player name: ", player));
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

    private String whoStartsFirst() {
        String symbolToPlayFirst = "";
        while(!inputParamsValidator.isValidSymbol(symbolToPlayFirst)){
            System.out.println(String.format("Who should start first? Type player symbol (%s or %s): ", Symbol.O, Symbol.X));
            symbolToPlayFirst = scanner.nextLine();
            if (!inputParamsValidator.isValidSymbol(symbolToPlayFirst))
                System.out.println(String.format("Please insert symbol %s (big o) or %s (big x), any other symbols will not be accepted."
                        , Symbol.O, Symbol.X));
        }
        return symbolToPlayFirst;
    }

    public String getCoordsToPutOnBoard() {
        System.out.print("Give me coordinates [pattern x y]: ");
        return scanner.nextLine();
    }
}
