package Data.Messenger;

import java.util.Locale;
import java.util.function.Consumer;

public class Messenger {
    private Consumer<String> output;
    private Translator translator;

    public Messenger(Locale language, Consumer<String> output) {
        translator = new Translator(language);
        this.output = output;
    }

    public void print(String message){
        output.accept(message);
    }

    public void print(MessageKeys keyForMessageKeys){
        print(keyForMessageKeys, new Object[0]);
    }

    public void print(MessageKeys keyForMessageKeys, Object... args) {
        String message = translator.getMessage(keyForMessageKeys);
        String formatterMessage = String.format(message, args);
        output.accept(formatterMessage);
    }

    public String translateKey(MessageKeys key) {
        return translator.getMessage(key);
    }
}
