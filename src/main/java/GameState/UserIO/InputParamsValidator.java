package GameState.UserIO;

public class InputParamsValidator {
    public boolean validateInsertedName(String name) throws InputCannotBeEmptyException, NumberFormatException {
        if (name.equals(""))
            throw new InputCannotBeEmptyException("You must insert something to input");
        return name.matches("[a-zA-Z]+");
    }

    public boolean isTableParamVaild(String tableParameter) {
        return isInteger(tableParameter) && Integer.valueOf(tableParameter) >= 3;
    }

    public boolean isInteger(String tableParameter) {
        return tableParameter.matches("-?\\d+");
    }

    public boolean isValidSymbol(String symbol) {
        return symbol.equals("O") || symbol.equals("X");
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
