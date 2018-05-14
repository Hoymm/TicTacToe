package gameState.userIO.startSettingsInput;

import data.Symbol;
import data.messenger.MessageKeys;
import data.messenger.Messenger;

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



    public StartSettings load() {
        return loadStartDataFromUser();
    }

    private StartSettings loadStartDataFromUser() {
        StartSettings startSettings = new StartSettings();
        startSettings = loadPlayerOName(startSettings);
        startSettings = loadPlayerXName(startSettings);
        startSettings = loadWhoStartFirst(startSettings);
        startSettings = loadBoardWidth(startSettings);
        startSettings = loadBoardHeight(startSettings);
        startSettings = loadHowManySymbolsInLineToWinRound(startSettings);
        return startSettings;
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

    private StartSettings loadPlayerOName(StartSettings startSettings) {
        startSettings.namePlayerO = questionAndValidatePlayerName(Symbol.O.toString());
        return startSettings;
    }

    private StartSettings loadPlayerXName(StartSettings startSettings) {
        startSettings.namePlayerX = questionAndValidatePlayerName(Symbol.X.toString());
        return startSettings;
    }

    private String questionAndValidatePlayerName(String player) {
        messenger.printf(MessageKeys.insertPlayerName, player);
        return userInputProvider.get().trim();
    }

    private StartSettings loadWhoStartFirst(StartSettings startSettings) {
        String symbolToPlayFirst = "";
        while(!startSettingsValidator.isValidSymbol(symbolToPlayFirst)){
            messenger.printf(MessageKeys.askWhichPlayerShouldStartFirst, Symbol.O, Symbol.X);
            symbolToPlayFirst = userInputProvider.get().trim();
            if (!startSettingsValidator.isValidSymbol(symbolToPlayFirst)){
                messenger.printf(MessageKeys.wrongSymbolToStartFirstInserted, Symbol.O, Symbol.X);
            }
        }
        startSettings.whoStartsFirst = Symbol.valueOf(symbolToPlayFirst.trim());
        return startSettings;
    }

    private StartSettings loadBoardWidth(StartSettings startSettings) {
        startSettings.boardWidth = loadAndValidateTableParam(messenger.translateKey(MessageKeys.width));
        return startSettings;
    }

    private StartSettings loadBoardHeight(StartSettings startSettings) {
        startSettings.boardHeight = loadAndValidateTableParam(messenger.translateKey(MessageKeys.height));
        return startSettings;
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

    private StartSettings loadHowManySymbolsInLineToWinRound(StartSettings startSettings) {
        int maxFromWidthAndHeightOfBoard = Math.max(startSettings.boardHeight, startSettings.boardWidth);
        startSettings.howManySymbolsInARowToWinRound = howManySymbolsInUnbrokenLineToWinRound(maxFromWidthAndHeightOfBoard);
        return startSettings;
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