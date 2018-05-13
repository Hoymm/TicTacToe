package GameState.UserIO;

import Data.Symbol;

public class InputParamsValidator {
    static final int MIN_BOARD_SIZE = 3, MAX_BOARD_SIZE = 50;

    public boolean isTableParamVaild(String tableParameter) {
        return isInteger(tableParameter) && Integer.valueOf(tableParameter) >= MIN_BOARD_SIZE
                && Integer.valueOf(tableParameter) <= MAX_BOARD_SIZE;
    }

    public boolean isItIntegerAndGraterOrEqualTo(String tableParameter, int compareTo) {
        if (isInteger(tableParameter))
            return Integer.valueOf(tableParameter) >= compareTo;
        return false;
    }

    public boolean isInteger(String tableParameter) {
        try{
            Integer.valueOf(tableParameter);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean isValidSymbol(String symbol) {
        return symbol.trim().equals(Symbol.X.name()) || symbol.trim().equals(Symbol.O.name());
    }

    public boolean isVaildBoardField(String negativeNumber) {
        try {
            int number = Integer.valueOf(negativeNumber);
            return number > 0;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
