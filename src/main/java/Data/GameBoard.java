package Data;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Map<Integer, Symbol> myBoard;
    private int width;
    private int height;

    public GameBoard(int width, int height) {
        myBoard = new HashMap<>();
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();

        myBoard.put(20, Symbol.X);

        for (int i = 0; i < height; ++i) {
            for (int j = 1; j <= width; ++j) {
                int key = width * i + j;
                tableDisplayInfoBuilder.append("|");
                if (!myBoard.containsKey(key))
                    tableDisplayInfoBuilder.append(String.format("%4d", key));
                else
                    tableDisplayInfoBuilder.append(String.format("%4s", myBoard.get(key)));

            }
            tableDisplayInfoBuilder.append("|");
            tableDisplayInfoBuilder.append("\n");
        }
        return tableDisplayInfoBuilder.toString();
    }


    public boolean markField(int fieldNumber, Symbol symbol) {
        if (myBoard.containsKey(fieldNumber) || fieldNumber < 1 || fieldNumber > width*height)
            return false;
        else{
            myBoard.put(fieldNumber, symbol);
            return true;
        }
    }
}
