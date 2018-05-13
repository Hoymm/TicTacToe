package gameState.userIO;
import data.messenger.MessageKeys;
import data.messenger.Messenger;
import data.Symbol;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputParams {
    private static final Logger LOGGER = Logger.getLogger(InputParams.class.getName());
    private InputParamsValidator inputParamsValidator;
    public final static String SEPARATOR = "*&*^";
    private Scanner scanner;
    private Messenger messenger;

    InputParams(Scanner scanner, Messenger messenger) {
        this.scanner = scanner;
        this.messenger = messenger;
        inputParamsValidator = new InputParamsValidator();
    }

    String getPlayerNamesAndBoardDataFromUser() {
        messenger.printf(MessageKeys.chooseCustomOrDefaultGameSettings);
        if (scanner.nextLine().equalsIgnoreCase("c")){
            messenger.printf(MessageKeys.customGameChoosen);
            return insertAndValidatePlayerName(Symbol.O.toString()) + SEPARATOR +
                    insertAndValidatePlayerName(Symbol.X.toString()) + SEPARATOR +
                    whoStartsFirst() + SEPARATOR +
                    howManyPointsToWinGame() + SEPARATOR +
                    insertAndValidateTableParam(messenger.translateKey(MessageKeys.width)) + SEPARATOR +
                    insertAndValidateTableParam(messenger.translateKey(MessageKeys.height));
        }
        else{
            messenger.printf(MessageKeys.defaultGameChoosen);
            return "Damian Andrzej O 3 3 3";
        }
    }

    private String insertAndValidatePlayerName(String player) {
        messenger.printf(MessageKeys.insertPlayerName, player);
        return scanner.nextLine();
    }

    private int insertAndValidateTableParam(String widthOrHeight) {
        String tableParameter = "";
        while(!inputParamsValidator.isTableParamVaild(tableParameter)){
            messenger.printf(MessageKeys.insertBoard, widthOrHeight);
            tableParameter = scanner.nextLine();
            if (!inputParamsValidator.isTableParamVaild(tableParameter)) {
                messenger.printf(MessageKeys.wrongBoardParameterInserted
                        ,InputParamsValidator.MIN_BOARD_SIZE, InputParamsValidator.MAX_BOARD_SIZE
                        , tableParameter, widthOrHeight);
            }
        }
        return Integer.valueOf(tableParameter);
    }

    private String whoStartsFirst() {
        String symbolToPlayFirst = "";
        while(!inputParamsValidator.isValidSymbol(symbolToPlayFirst)){
            messenger.printf(MessageKeys.askWhichPlayerShouldStartFirst, Symbol.O, Symbol.X);
            symbolToPlayFirst = scanner.nextLine();
            if (!inputParamsValidator.isValidSymbol(symbolToPlayFirst)) {
                messenger.printf(MessageKeys.wrongSymbolToStartFirstInserted, Symbol.O, Symbol.X);
            }
        }
        return symbolToPlayFirst;
    }

    private String howManyPointsToWinGame() {
        int minimumAmountOfPointsInRowToWin = 3;
        String pointsToWinGame = "";
        while(howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)){
            messenger.printf(MessageKeys.askHowManySymbolsInUnbrokenLineToWinGame);
            pointsToWinGame = scanner.nextLine();
            if (howManyPointsToWinGameConditionChecker(minimumAmountOfPointsInRowToWin, pointsToWinGame)) {
                messenger.printf(MessageKeys.howManySymbolsInUnbrokenLineToWinGameWrongInput, pointsToWinGame);
            }
        }
        return pointsToWinGame;

    }

    private boolean howManyPointsToWinGameConditionChecker(int minimumAmountOfPointsInRowToWin, String pointsToWinGame) {
        return !inputParamsValidator.isItIntegerAndGraterOrEqualTo(pointsToWinGame, minimumAmountOfPointsInRowToWin) && notAQuitCommand(pointsToWinGame);
    }

    String getCoordsToPutOnBoard() {
        String fieldToMark = "";
        while(!inputParamsValidator.isVaildBoardField(fieldToMark) && notAQuitCommand(fieldToMark)){
            messenger.printf(MessageKeys.giveMeNumberOfField);
            fieldToMark = scanner.nextLine();
            if (!inputParamsValidator.isVaildBoardField(fieldToMark) && notAQuitCommand(fieldToMark)) {
                messenger.printf(MessageKeys.boardFieldMustBePossitiveNumber, fieldToMark);
            }
        }
        return fieldToMark;
    }

    private boolean notAQuitCommand(String command) {
        return !command.equalsIgnoreCase(getQuitCommand());
    }

    String getQuitCommand(){
        return messenger.translateKey(MessageKeys.quit);
    }
}
