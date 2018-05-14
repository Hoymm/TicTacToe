package gameState.userIO.startSettingsInput;

import data.Symbol;
import data.messenger.Messenger;
import gameState.userIO.InputParamsValidator;

public class StartSettingsValidator {
    private final InputParamsValidator validator = new InputParamsValidator();
    public static final int MIN_BOARD_SIZE = 3, MAX_BOARD_SIZE = 50;
    private static final int HOW_MANY_SYMBOLS_IN_UNBROKEN_LINE_MINIMUM_TO_WIN = 3;

    public boolean isValidSymbol(String symbol) {
        return symbol.trim().equals(Symbol.X.name()) || symbol.trim().equals(Symbol.O.name());
    }

    public boolean isTableParamVaild(String tableParameter) {
        return validator.isInteger(tableParameter) && Integer.valueOf(tableParameter) >= MIN_BOARD_SIZE
                && Integer.valueOf(tableParameter) <= MAX_BOARD_SIZE;
    }

    public boolean isHowManySymbolsInUnbrokenLineToWinRoundInvalid(String unbrokenSymbolsLineToWinRoundString
            , int HOW_MANY_SYMBOLS_IN_UNBROKEN_LINE_MAX_TO_WIN, Messenger messenger) {

        if (validator.isNotAQuitCommand(unbrokenSymbolsLineToWinRoundString, messenger) && validator.isInteger(unbrokenSymbolsLineToWinRoundString)){
            int unbrokenSymbolsLineToWinRound = Integer.valueOf(unbrokenSymbolsLineToWinRoundString);

            return HOW_MANY_SYMBOLS_IN_UNBROKEN_LINE_MINIMUM_TO_WIN > unbrokenSymbolsLineToWinRound
                    || unbrokenSymbolsLineToWinRound > HOW_MANY_SYMBOLS_IN_UNBROKEN_LINE_MAX_TO_WIN;
        }
        return true;
    }
}
