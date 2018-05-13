package gameState.userIO;

import data.messenger.MessageKeys;
import data.messenger.Messenger;

public class InputParamsValidator {
    public boolean isNotAQuitCommand(String command, Messenger messenger) {
        return !command.equalsIgnoreCase(getQuitCommand(messenger));
    }

    public String getQuitCommand(Messenger messenger){
        return messenger.translateKey(MessageKeys.quit);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isFieldPossitiveInteger(String fieldToMarkString) {
        return isInteger(fieldToMarkString) && Integer.valueOf(fieldToMarkString) > 0;
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
}
