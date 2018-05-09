package GameState.UserIO;
import Data.MessageKeys;
import Data.Messenger;
import Data.Symbol;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputParams {
    static final Logger LOGGER = Logger.getLogger(InputParams.class.getName());
    private InputParamsValidator inputParamsValidator;
    public final static String SEPARATOR = " ";
    private Scanner scanner;
    private Messenger messenger;

    InputParams(Scanner scanner, Messenger messenger) {
        this.scanner = scanner;
        this.messenger = messenger;
        inputParamsValidator = new InputParamsValidator();
    }

    public String getPlayerNamesAndBoardDataFromUser() {
        messenger.print(MessageKeys.chooseCustomOrDefaultGameSettings);
        if (scanner.nextLine().equalsIgnoreCase("c")){
            messenger.print(MessageKeys.customGameChoosen);
            StringBuilder builderUserInput = new StringBuilder();
            builderUserInput.append(insertAndValidatePlayerName(Symbol.O.toString())).append(SEPARATOR)
                    .append(insertAndValidatePlayerName(Symbol.X.toString())).append(SEPARATOR)
                    .append(whoStartsFirst()).append(SEPARATOR)
                    .append(howManyPointsToWinGame()).append(SEPARATOR)
                    .append(insertAndValidateTableParam(messenger.translateKey(MessageKeys.width))).append(SEPARATOR)
                    .append(insertAndValidateTableParam(messenger.translateKey(MessageKeys.height)));
            return builderUserInput.toString();
        }
        else{
            messenger.print(MessageKeys.defaultGameChoosen);
            return "Damian Andrzej O 3 3 3";
        }
    }

    private String insertAndValidatePlayerName(String player) {
        String playerName = "";
        boolean validationPassed = false;
        while (!validationPassed){
            messenger.print(MessageKeys.insertPlayerName, player);
            try {
                playerName = scanner.nextLine();
                validationPassed = inputParamsValidator.validateInsertedName(playerName);
            } catch (InputCannotBeEmptyException e) {
                LOGGER.warning("User tried to insert empty name");
            }
            if (!validationPassed)
                messenger.print(MessageKeys.nameShouldContainOnlyLetters, playerName);
        }
        return playerName;
    }

    private int insertAndValidateTableParam(String widthOrHeight) {
        String tableParameter = "";
        while(!inputParamsValidator.isTableParamVaild(tableParameter)){
            messenger.print(MessageKeys.insertBoard, widthOrHeight);
            tableParameter = scanner.nextLine();
            if (!inputParamsValidator.isTableParamVaild(tableParameter)) {
                messenger.print(MessageKeys.wrongBoardParameterInserted, tableParameter, widthOrHeight);
            }
        }
        return Integer.valueOf(tableParameter);
    }

    private String whoStartsFirst() {
        String symbolToPlayFirst = "";
        while(!inputParamsValidator.isValidSymbol(symbolToPlayFirst)){
            messenger.print(MessageKeys.askWhichPlayerShouldStartFirst, Symbol.O, Symbol.X);
            symbolToPlayFirst = scanner.nextLine();
            if (!inputParamsValidator.isValidSymbol(symbolToPlayFirst)) {
                messenger.print(MessageKeys.wrongSymbolToStartFirstInserted, Symbol.O, Symbol.X);
            }
        }
        return symbolToPlayFirst;
    }

    private String howManyPointsToWinGame() {
        int minimumAmountOfPointsInRowToWin = 3;
        String pointsToWinGame = "";
        while(howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)){
            messenger.print(MessageKeys.askHowManySymbolsInUnbrokenLineToWinGame);
            pointsToWinGame = scanner.nextLine();
            if (howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)) {
                messenger.print(MessageKeys.howManySymbolsInUnbrokenLineToWinGameWrongInput, pointsToWinGame);
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
            messenger.print(MessageKeys.giveMeNumberOfField);
            fieldToMark = scanner.nextLine();
            if (!inputParamsValidator.isVaildBoardField(fieldToMark) && !isItQuitCommand(fieldToMark)) {
                messenger.print(MessageKeys.boardFieldMustBePossitiveNumber, fieldToMark);
            }
        }
        return fieldToMark;
    }

    boolean isItQuitCommand(String command) {
        return command.equalsIgnoreCase(getQuitCommand());
    }

    public String getQuitCommand(){
        return messenger.translateKey(MessageKeys.quit);
    }
}
