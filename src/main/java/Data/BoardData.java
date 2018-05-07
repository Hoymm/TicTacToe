package Data;

import java.util.LinkedHashMap;

public class BoardData {
    LinkedHashMap<Integer, Symbol> myBoard;
    int width;
    int height;

    public BoardData(int width, int height) {
        this.width = width;
        this.height = height;
        myBoard = new LinkedHashMap<>();
    }
}
