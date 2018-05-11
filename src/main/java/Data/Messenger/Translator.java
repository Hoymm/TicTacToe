package Data.Messenger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    private Locale language;

    public Translator(Locale language) {
        this.language = language;
    }

    public String getMessage(MessageKeys keyForMessageKeys) {
        ResourceBundle bundle = ResourceBundle.getBundle("language", language);
        return bundle.getString(keyForMessageKeys.name());
    }
}
