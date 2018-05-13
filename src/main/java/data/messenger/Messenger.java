package data.messenger;

import java.util.Locale;
import java.util.function.Consumer;

public class Messenger {
    private Consumer<String> output;
    private Translator translator;

    public Messenger(Locale language, Consumer<String> output) {
        translator = new Translator(language);
        this.output = output;
    }

    public void printf(String message){
        output.accept(message);
    }

    public void printf(MessageKeys keyForMessageKeys){
        printf(keyForMessageKeys, new Object[0]);
    }

    public void printf(MessageKeys keyForMessageKeys, Object... args) {
        String message = translator.getMessage(keyForMessageKeys);
        String formatterMessage = String.format(message, args);
        output.accept(formatterMessage);
    }

    public String translateKey(MessageKeys key) {
        return translator.getMessage(key);
    }
}
