import gameState.LocaleLanguages;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale language = loadLanguageIfInserted(args);
        XOGame XOGame = new XOGame(language);
        XOGame.runGame();
    }

    private static Locale loadLanguageIfInserted(String[] args) {
        return args.length == 0 ? LocaleLanguages.valueOf("").getLanguage() : LocaleLanguages.valueOf(args[0]).getLanguage();
    }
}
