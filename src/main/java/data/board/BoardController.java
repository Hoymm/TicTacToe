package data.board;
import data.round.GameRoundStateChecker;
import data.Symbol;
import data.round.roundState.RoundState;

public class BoardController {
    final private BoardData gameBoardData;
    final private GameRoundStateChecker gameRoundStateChecker;
    private int fieldCounter;

    public BoardController(BoardData gameBoardData, int howManySymbolsInUnbrokenLineToWin) {
        this.gameBoardData = gameBoardData;
        gameRoundStateChecker = new GameRoundStateChecker(howManySymbolsInUnbrokenLineToWin);
    }

    @Override
    public String toString() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        tableDisplayInfoBuilder.append(getDisplayTopLineOfBoard()).append("\n");

        fieldCounter = 1;
        for (int levelCountingFromTop = 0; levelCountingFromTop < gameBoardData.height; ++levelCountingFromTop){
            tableDisplayInfoBuilder
                    .append(getDisplayLine_withEmptySpacesInsideField()).append("\n")
                    .append(getDisplayLine_withSymbolOrNumberInsideField()).append("\n")
                    .append(getDisplayLine_verticalSeparatorBetweenFields()).append("\n");
        }
        return tableDisplayInfoBuilder.toString();
    }

    private String getDisplayLine_withSymbolOrNumberInsideField() {
        StringBuilder displayLineWithEmptySpaces = new StringBuilder();
        for (int i = 0; i < gameBoardData.width; ++i) {
            Symbol symbolOnField = gameBoardData.getSymbolFromField(fieldCounter);

            displayLineWithEmptySpaces.append("|");

            if (symbolOnField != null || String.valueOf(fieldCounter).length() < 3) {
                displayLineWithEmptySpaces.append(" ");
            }

            displayLineWithEmptySpaces.append(symbolOnField == null ? fieldCounter : symbolOnField);

            if (symbolOnField != null || String.valueOf(fieldCounter).length() < 2) {
                displayLineWithEmptySpaces.append(" ");
            }

            ++fieldCounter;
        }
        return displayLineWithEmptySpaces.append("|").toString();
    }

    private String getDisplayTopLineOfBoard() {
        return new String(new char[gameBoardData.width*4+1]).replace("\0", "_");
    }

    private String getDisplayLine_verticalSeparatorBetweenFields() {
        return getHorizontalLineOfBoardDisplayWithHorizontalSeparators("___");
    }

    private String getDisplayLine_withEmptySpacesInsideField() {
        return getHorizontalLineOfBoardDisplayWithHorizontalSeparators("   ");
    }

    private String getHorizontalLineOfBoardDisplayWithHorizontalSeparators(String spaceBetweenSeparators) {
        StringBuilder displayLineWithEmptySpaces = new StringBuilder();
        for (int i = 0; i < gameBoardData.width; ++i) {
            displayLineWithEmptySpaces.append("|")
                    .append(spaceBetweenSeparators);
        }
        return displayLineWithEmptySpaces.append("|").toString();
    }


    public boolean tryMarkFieldAndChangeWinnerStateIfNeeded(int fieldNumber, Symbol symbol) {
        if (gameBoardData.isFieldOccupied(fieldNumber) || fieldNumber < 1 || fieldNumber > gameBoardData.width*gameBoardData.height)
            return false;
        else{
            gameBoardData.putSymbolToField(symbol, fieldNumber);
            gameRoundStateChecker.updateState(gameBoardData, fieldNumber);
            return true;
        }
    }

    public RoundState getRoundState() {
        return gameRoundStateChecker.getRoundState();
    }

    public void prepareNewRound(){
        resetBoard();
        setRoundStateToUnfinished();
    }

    private void resetBoard() {
        gameBoardData.clearSymbolsFromBoard();
    }

    private void setRoundStateToUnfinished() {
        gameRoundStateChecker.setStateUnfinished();
    }
}
