package UserIO;

public class InputParamsValidator {
    public boolean validateInsertedName(String name) throws InputCannotBeEmptyException, NumberFormatException {
        if (name.equals(""))
            throw new InputCannotBeEmptyException("You must insert something to input");
       return name.matches("[a-zA-Z]+");
    }
}
