package gameState.userIO.startSettingsInput;

import data.Symbol;
import messenger.MessageKeys;
import messenger.Messenger;

import java.util.function.Supplier;

public class StartSettingsLoader {
    private final Supplier<String> userInputProvider;
    private final Messenger messenger;
    private final StartSettingsValidator startSettingsValidator;

    public StartSettingsLoader(Supplier<String> userInputProvider, Messenger messenger) {
        this.userInputProvider = userInputProvider;
        this.messenger = messenger;
        startSettingsValidator = new StartSettingsValidator();
    }

    public static StartSettings loadExampleData() {
        StartSettings startSettings = new StartSettings();
        startSettings.namePlayerO = "Damian";
        startSettings.namePlayerX = "Andrzej";
        startSettings.whoStartsFirst = Symbol.O;
        startSettings.boardWidth = 3;
        startSettings.boardHeight = 3;
        startSettings.howManySymbolsInARowToWinRound = 3;
        return startSettings;
    }

    public StartSettings load() {
        return loadStartDataFromUser();
    }

    private StartSettings loadStartDataFromUser() {
        StartSettings startSettings = new StartSettings();
        loadPlayerNames(startSettings);
        loadWhoStartFirst(startSettings);
        loadBoardParams(startSettings);
        return startSettings;
    }

    private void loadPlayerNames(StartSettings startSettings) {
        loadPlayerOName(startSettings);
        loadPlayerXName(startSettings);
    }

    private void loadBoardParams(StartSettings startSettings) {
        loadBoardWidth(startSettings);
        loadBoardHeight(startSettings);
        loadHowManySymbolsInLineToWinRound(startSettings);
    }

    private void loadPlayerOName(StartSettings startSettings) {
        startSettings.namePlayerO = questionAndValidatePlayerName(Symbol.O.toString());
    }

    private void loadPlayerXName(StartSettings startSettings) {
        startSettings.namePlayerX = questionAndValidatePlayerName(Symbol.X.toString());
    }

    private String questionAndValidatePlayerName(String symbolName) {
        String nameToReturn;
        do {
            messenger.printf(MessageKeys.insertPlayerName, symbolName);
            nameToReturn = userInputProvider.get().trim();
            if (nameToReturn.length() == 0) {
                messenger.printf(MessageKeys.nameCannotBeEmpty);
            }
        }while (nameToReturn.length() == 0);
        return nameToReturn;
    }

    private void loadWhoStartFirst(StartSettings startSettings) {
        String symbolToPlayFirst = "";
        while(!startSettingsValidator.isValidSymbol(symbolToPlayFirst)){
            messenger.printf(MessageKeys.questionAboutStartingPlayer, Symbol.O, Symbol.X);
            symbolToPlayFirst = userInputProvider.get().trim().toUpperCase();
            if (!startSettingsValidator.isValidSymbol(symbolToPlayFirst)){
                messenger.printf(MessageKeys.wrongSymbolToStart, Symbol.O, Symbol.X);
            }
        }
        startSettings.whoStartsFirst = Symbol.valueOf(symbolToPlayFirst.trim());
    }

    private void loadBoardWidth(StartSettings startSettings) {
        startSettings.boardWidth = loadAndValidateTableParam(messenger.translateKey(MessageKeys.width));
    }

    private void loadBoardHeight(StartSettings startSettings) {
        startSettings.boardHeight = loadAndValidateTableParam(messenger.translateKey(MessageKeys.height));
    }

    private int loadAndValidateTableParam(String widthOrHeight) {
        String tableParameterString = "";
        while(!startSettingsValidator.isTableParamVaild(tableParameterString)){
            messenger.printf(MessageKeys.insertBoard, widthOrHeight);
            tableParameterString = userInputProvider.get().trim();
            if (!startSettingsValidator.isTableParamVaild(tableParameterString)) {
                messenger.printf(MessageKeys.wrongBoardParameterInserted
                        , StartSettingsValidator.MIN_BOARD_SIZE, StartSettingsValidator.MAX_BOARD_SIZE
                        , tableParameterString, widthOrHeight);
            }
        }
        return Integer.valueOf(tableParameterString);
    }

    private void loadHowManySymbolsInLineToWinRound(StartSettings startSettings) {
        int maxFromWidthAndHeightOfBoard = Math.max(startSettings.boardHeight, startSettings.boardWidth);
        startSettings.howManySymbolsInARowToWinRound = howManySymbolsInUnbrokenLineToWinRound(maxFromWidthAndHeightOfBoard);
    }

    private int howManySymbolsInUnbrokenLineToWinRound(int maxFromBoardWidthAndHeight) {
        String symbolsInUnbrokenLineToWin = "";
        while(startSettingsValidator.isHowManySymbolsInUnbrokenLineToWinRoundInvalid
                (symbolsInUnbrokenLineToWin, maxFromBoardWidthAndHeight, messenger)){

            messenger.printf(MessageKeys.askHowManySymbolsInUnbrokenLineToWinGame);
            symbolsInUnbrokenLineToWin = userInputProvider.get().trim();

            if (startSettingsValidator.isHowManySymbolsInUnbrokenLineToWinRoundInvalid
                    (symbolsInUnbrokenLineToWin, maxFromBoardWidthAndHeight, messenger)) {
                messenger.printf(MessageKeys.howManySymbolsInUnbrokenLineToWinGameWrongInput
                        , StartSettingsValidator.MIN_BOARD_SIZE, maxFromBoardWidthAndHeight, symbolsInUnbrokenLineToWin);
            }
        }
        return Integer.valueOf(symbolsInUnbrokenLineToWin);
    }
}