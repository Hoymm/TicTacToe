package messenger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    private ResourceBundle bundle;

    public Translator(Locale language) {
        bundle = ResourceBundle.getBundle("language", language);
    }

    public String getMessage(MessageKeys keyForMessageKeys) {
        return bundle.getString(keyForMessageKeys.name());
    }
}
