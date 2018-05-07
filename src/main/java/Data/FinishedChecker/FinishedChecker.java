package Data.FinishedChecker;

import Data.Symbol;

import java.util.LinkedHashMap;

public class FinishedChecker {
    private FinishState finishState;

    public FinishedChecker() {
        this.finishState = FinishState.NotFinished;
    }



    public FinishState getFinishedState(){
        return finishState;
    }

    public void updateState(LinkedHashMap<Integer, Symbol> myBoard, int fieldNumber) {
        if (fieldNumber == 100)
            finishState = FinishState.OWon;
    }
}
