package Data;

import java.util.Locale;
import java.util.function.Consumer;

public class Speaker {
    private Consumer<String> output;
    private Translator translator;

    public Speaker(Locale language) {
        translator = new Translator(language);
    }

    public Speaker(Locale language, Consumer<String> output) {
        translator = new Translator(language);
        this.output = output;
    }

    public String printOutputViaKey(Message keyForMessage){
        String message = translator.getMessage(keyForMessage);
        output.accept(message);
        return message;
    }
}
