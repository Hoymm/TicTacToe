package Data;
import Data.FinishedChecker.FinishStates;
import Data.FinishedChecker.FinishedChecker;

import java.util.LinkedHashMap;

public class GameBoard {
    private LinkedHashMap<Integer, Symbol> myBoard;
    private int width;
    private int height;
    private FinishedChecker finishedChecker;

    public GameBoard(int width, int height) {
        myBoard = new LinkedHashMap<Integer, Symbol>();
        this.height = height;
        this.width = width;
        finishedChecker = new FinishedChecker();
    }

    @Override
    public String toString() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        for (int i = 0; i < height; ++i) {
            for (int j = 1; j <= width; ++j) {
                int key = width * i + j;
                tableDisplayInfoBuilder.append("|");
                if (!myBoard.containsKey(key))
                    tableDisplayInfoBuilder.append(String.format("%4d", key));
                else
                    tableDisplayInfoBuilder.append(String.format("%13s", myBoard.get(key)));

            }
            tableDisplayInfoBuilder.append("|");
            tableDisplayInfoBuilder.append("\n");
        }
        return tableDisplayInfoBuilder.toString();
    }


    public boolean tryMarkField(int fieldNumber, Symbol symbol) {
        if (myBoard.containsKey(fieldNumber) || fieldNumber < 1 || fieldNumber > width*height)
            return false;
        else{
            myBoard.put(fieldNumber, symbol);
            return true;
        }
    }

    FinishStates getFinishedState() {
        return finishedChecker.getGameFinishedState();
    }
}
