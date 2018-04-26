package InfoDisplayer;

import Data.CurGameStateInfo;

public class InfoDisplayer {
    public void displayCurGameState(CurGameStateInfo infoDisplayer) {
        System.out.println(infoDisplayer.headerInfo());
        System.out.println(infoDisplayer.boardInfo());
    }
}
