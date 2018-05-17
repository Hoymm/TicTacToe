package gameState.userIO;
import messenger.MessageKeys;
import messenger.Messenger;
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
        String userEntry = "";
        while(isFieldBoardEntryInvalid(userEntry)){
            messenger.printf(MessageKeys.giveMeNumberOfField);
            userEntry = userInputData.get().trim();
            if (isFieldBoardEntryInvalid(userEntry)) {
                messenger.printf(MessageKeys.boardFieldMustBePossitiveNumber, userEntry);
            }
        }
        return userEntry;
    }

    private boolean isFieldBoardEntryInvalid(String userEntry) {
        return !inputParamsValidator.isFieldPossitiveInteger(userEntry) && inputParamsValidator.isNotAQuitCommand(userEntry, messenger);
    }

    String getQuitCommand() {
        return inputParamsValidator.getQuitCommand(messenger);
    }
}
