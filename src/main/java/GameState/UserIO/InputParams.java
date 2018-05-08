package GameState.UserIO;
import Data.MessageKeys;
import Data.Messeger;
import Data.Symbol;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputParams {
    static final Logger LOGGER = Logger.getLogger(InputParams.class.getName());
    private InputParamsValidator inputParamsValidator;
    public final static String SEPARATOR = " ";
    private Scanner scanner;
    private Messeger messeger;

    InputParams(Scanner scanner, Messeger messeger) {
        this.scanner = scanner;
        this.messeger = messeger;
        inputParamsValidator = new InputParamsValidator();
    }

    public String getPlayerNamesAndBoardDataFromUser() {
        messeger.print(MessageKeys.chooseCustomOrDefaultGameSettings);
        if (scanner.nextLine().equalsIgnoreCase("c")){
            messeger.print(MessageKeys.customGameChoosen);
            StringBuilder builderUserInput = new StringBuilder();
            builderUserInput.append(insertAndValidatePlayerName(Symbol.O.toString())).append(SEPARATOR)
                    .append(insertAndValidatePlayerName(Symbol.X.toString())).append(SEPARATOR)
                    .append(whoStartsFirst()).append(SEPARATOR)
                    .append(howManyPointsToWinGame()).append(SEPARATOR)
                    .append(insertAndValidateTableParam(messeger.translateKey(MessageKeys.width))).append(SEPARATOR)
                    .append(insertAndValidateTableParam(messeger.translateKey(MessageKeys.height)));
            return builderUserInput.toString();
        }
        else{
            messeger.print(MessageKeys.defaultGameChoosen);
            return "Damian Andrzej O 3 3 3";
        }
    }

    private String insertAndValidatePlayerName(String player) {
        String playerName = "";
        boolean validationPassed = false;
        while (!validationPassed){
            messeger.print(MessageKeys.insertPlayerName, player);
            try {
                playerName = scanner.nextLine();
                validationPassed = inputParamsValidator.validateInsertedName(playerName);
            } catch (InputCannotBeEmptyException e) {
                LOGGER.warning("User tried to insert empty name");
            }
            if (!validationPassed)
                messeger.print(MessageKeys.nameShouldContainOnlyLetters, playerName);
        }
        return playerName;
    }

    private int insertAndValidateTableParam(String widthOrHeight) {
        String tableParameter = "";
        while(!inputParamsValidator.isTableParamVaild(tableParameter)){
            messeger.print(MessageKeys.insertBoard, widthOrHeight);
            tableParameter = scanner.nextLine();
            if (!inputParamsValidator.isTableParamVaild(tableParameter)) {
                messeger.print(MessageKeys.wrongBoardParameterInserted, tableParameter, widthOrHeight);
            }
        }
        return Integer.valueOf(tableParameter);
    }

    private String whoStartsFirst() {
        String symbolToPlayFirst = "";
        while(!inputParamsValidator.isValidSymbol(symbolToPlayFirst)){
            messeger.print(MessageKeys.askWhichPlayerShouldStartFirst, Symbol.O, Symbol.X);
            symbolToPlayFirst = scanner.nextLine();
            if (!inputParamsValidator.isValidSymbol(symbolToPlayFirst)) {
                messeger.print(MessageKeys.wrongSymbolToStartFirstInserted, Symbol.O, Symbol.X);
            }
        }
        return symbolToPlayFirst;
    }

    private String howManyPointsToWinGame() {
        int minimumAmountOfPointsInRowToWin = 3;
        String pointsToWinGame = "";
        while(howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)){
            messeger.print(MessageKeys.askHowManySymbolsInUnbrokenLineToWinGame);
            pointsToWinGame = scanner.nextLine();
            if (howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)) {
                messeger.print(MessageKeys.howManySymbolsInUnbrokenLineToWinGameWrongInput, pointsToWinGame);
            }
        }
        return pointsToWinGame;

    }

    private boolean howManyPointsToWinGameConditionChecker(int minimumAmountOfPointsInRowToWin, String pointsToWinGame) {
        return !inputParamsValidator.isItIntegerAndGraterOrEqualTo(pointsToWinGame, minimumAmountOfPointsInRowToWin) && !isItQuitCommand(pointsToWinGame);
    }

    public String getCoordsToPutOnBoard() {
        String fieldToMark = "";
        while(!inputParamsValidator.isVaildBoardField(fieldToMark) && !isItQuitCommand(fieldToMark)){
            messeger.print(MessageKeys.giveMeNumberOfField);
            fieldToMark = scanner.nextLine();
            if (!inputParamsValidator.isVaildBoardField(fieldToMark) && !isItQuitCommand(fieldToMark)) {
                messeger.print(MessageKeys.boardFieldMustBePossitiveNumber, fieldToMark);
            }
        }
        return fieldToMark;
    }

    boolean isItQuitCommand(String command) {
        return command.equalsIgnoreCase(getQuitCommand());
    }

    public String getQuitCommand(){
        return messeger.translateKey(MessageKeys.quit);
    }
}
