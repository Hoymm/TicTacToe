package InfoDisplayer;

import Data.CurGameDataInfo;

public class InfoDisplayer {
    public void displayCurGameData(CurGameDataInfo infoDisplayer) {
        System.out.println(infoDisplayer.headerInfo());
        System.out.println(infoDisplayer.boardInfo());
    }
}
