package InfoDisplayer;

import Data.DisplayInfoProvider;

public class InfoDisplayer {
    public void displayCurGameState(DisplayInfoProvider infoDisplayer) {
        System.out.println(infoDisplayer.headerInfo());
        System.out.println(infoDisplayer.boardInfo());
    }
}
