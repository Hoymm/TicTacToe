package GameState;

import java.util.Locale;
public enum LocaleLanguages {
    PL{
        @Override
        public Locale getLanguage() {
            return new Locale("pl", "PL");
        }
    },
    ENG{
        @Override
        public Locale getLanguage() {
            return Locale.ENGLISH;
        }
    };

    public Locale getLanguage(){
        return new Locale("pl", "PL");
    }
}
