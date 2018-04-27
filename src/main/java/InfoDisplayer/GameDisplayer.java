package InfoDisplayer;

import Data.CurGameDataInfo;

public class GameDisplayer {
    public void display(CurGameDataInfo infoDisplayer) {
        System.out.println(infoDisplayer.headerInfo());
        System.out.println(infoDisplayer.boardInfo());
    }
}
