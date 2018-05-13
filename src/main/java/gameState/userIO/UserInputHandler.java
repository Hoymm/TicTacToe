package gameState.userIO;
import data.messenger.MessageKeys;
import data.messenger.Messenger;
import gameState.userIO.startSettingsInput.StartSettings;
import gameState.userIO.startSettingsInput.StartSettingsLoader;

import java.util.function.Supplier;

class UserInputHandler {
    private final InputParamsValidator inputParamsValidator;
    private final Supplier<String> userInputData;
    private final Messenger messenger;

    UserInputHandler(Supplier<String> userInputData, Messenger messenger) {
        this.userInputData = userInputData;
        this.messenger = messenger;
        inputParamsValidator = new InputParamsValidator();
    }

    StartSettings getStartSettings() {
        StartSettingsLoader startSettingsLoader = new StartSettingsLoader(userInputData, messenger);
        messenger.printf(MessageKeys.chooseCustomOrDefaultGameSettings);

        if (userInputData.get().equalsIgnoreCase("c")){
            messenger.printf(MessageKeys.customGameChoosen);
            return startSettingsLoader.load();
        }
        else{
            messenger.printf(MessageKeys.defaultGameChoosen);
            return StartSettingsLoader.loadExampleData();
        }
    }

    String getCoordsToPutOnBoard() {
        String userInput = "";
        while(!inputParamsValidator.isFieldPossitiveInteger(userInput)
                && inputParamsValidator.isNotAQuitCommand(userInput, messenger)){
            messenger.printf(MessageKeys.giveMeNumberOfField);
            userInput = userInputData.get();
            if (!inputParamsValidator.isFieldPossitiveInteger(userInput)
                    && inputParamsValidator.isNotAQuitCommand(userInput, messenger)) {
                messenger.printf(MessageKeys.boardFieldMustBePossitiveNumber, userInput);
            }
        }
        return userInput;
    }

    String getQuitCommand() {
        return inputParamsValidator.getQuitCommand(messenger);
    }
}
