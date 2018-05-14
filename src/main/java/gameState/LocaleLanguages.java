package gameState;

import java.util.Locale;
@SuppressWarnings("unused")
public enum LocaleLanguages {
    PL{
        @Override
        public Locale  getLanguage() {
            return new Locale("pl", "PL");
        }
    },
    ENG{
        @Override
        public Locale getLanguage() {
            return Locale.ENGLISH;
        }
    };

    public static Locale getDefaultLanguage() {
        return new Locale("pl", "PL");
    }

    public Locale getLanguage(){
        return new Locale("pl", "PL");
    }
}
