package Data;

public class BoardController {
    private BoardData gameBoardData;
    private FinishedChecker finishedChecker;

    public BoardController(BoardData gameBoardData, int howManyInRowToWin) {
        this.gameBoardData = gameBoardData;
        finishedChecker = new FinishedChecker(howManyInRowToWin);
    }

    @Override
    public String toString() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        for (int i = 0; i < gameBoardData.height; ++i) {
            for (int j = 1; j <= gameBoardData.width; ++j) {
                int key = gameBoardData.width * i + j;
                tableDisplayInfoBuilder.append("|");
                if (!gameBoardData.isFieldOccupied(key))
                    tableDisplayInfoBuilder.append(String.format("%4d", key));
                else
                    tableDisplayInfoBuilder.append(String.format("%13s", gameBoardData.getSymbolFromField(key)));

            }
            tableDisplayInfoBuilder.append("|");
            tableDisplayInfoBuilder.append("\n");
        }
        return tableDisplayInfoBuilder.toString();
    }


    public boolean tryMarkFieldAndChangeWinnerStateIfNeeded(int fieldNumber, Symbol symbol) {
        if (gameBoardData.isFieldOccupied(fieldNumber) || fieldNumber < 1 || fieldNumber > gameBoardData.width*gameBoardData.height)
            return false;
        else{
            gameBoardData.putSymbolToField(symbol, fieldNumber);
            finishedChecker.updateState(gameBoardData, fieldNumber);
            return true;
        }
    }

    public FinishState getFinishedState() {
        return finishedChecker.getFinishedState();
    }
}
