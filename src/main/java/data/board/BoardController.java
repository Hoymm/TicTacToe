package data.board;
import data.round.GameRoundStateChecker;
import data.Symbol;
import data.round.roundState.RoundState;

public class BoardController {
    final private BoardData gameBoardData;
    final private GameRoundStateChecker gameRoundStateChecker;
    final private BoardDrawer boardDrawer;

    public BoardController(BoardData gameBoardData, int howManySymbolsInUnbrokenLineToWin) {
        this.gameBoardData = gameBoardData;
        gameRoundStateChecker = new GameRoundStateChecker(howManySymbolsInUnbrokenLineToWin);
        boardDrawer = new BoardDrawer();
    }

    @Override
    public String toString() {
        return calculateStringDisplayingGameBoard();
    }

    private String calculateStringDisplayingGameBoard() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        tableDisplayInfoBuilder.append(boardDrawer.getDisplayTopLineOfBoard(gameBoardData)).append("\n");

        int curFirstLeftColumnNumber = 1;
        for (int levelCountingFromTop = 0; levelCountingFromTop < gameBoardData.height; ++levelCountingFromTop){
            tableDisplayInfoBuilder
                    .append(boardDrawer.getDisplayLine_withEmptySpacesInsideField(gameBoardData)).append("\n")
                    .append(boardDrawer.getDisplayLine_withSymbolOrNumberInsideField(gameBoardData, curFirstLeftColumnNumber)).append("\n")
                    .append(boardDrawer.getDisplayLine_verticalSeparatorBetweenFields(gameBoardData)).append("\n");
            curFirstLeftColumnNumber += gameBoardData.width;
        }
        return tableDisplayInfoBuilder.toString();
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
