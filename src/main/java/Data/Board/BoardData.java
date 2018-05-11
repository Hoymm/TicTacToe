package Data.Board;
import Data.Symbol;

import java.util.LinkedHashMap;

public class BoardData {
    private LinkedHashMap<Integer, Symbol> myBoard;
    int width;
    int height;

    public BoardData(int width, int height) {
        this.width = width;
        this.height = height;
        myBoard = new LinkedHashMap<>();
    }

    public void putSymbolToField(Symbol symbol, int fieldNumber) {
        myBoard.put(fieldNumber, symbol);
    }

    public Symbol getSymbolFromField(int fieldNumber) {
        return myBoard.get(fieldNumber);
    }

    boolean isFieldOccupied(int fieldNumber) {
        return myBoard.containsKey(fieldNumber);
    }

    public boolean isBoardFull() {
        return myBoard.size() == width*height;
    }

    void clearSymbolsFromBoard() {
        myBoard = new LinkedHashMap<>();
    }
}
