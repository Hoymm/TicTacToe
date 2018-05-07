package Data;

public class FinishedChecker {
    private int howManyInRowToWin;
    private FinishState finishState;

    public FinishedChecker(int howManyInRowToWin) {
        this.howManyInRowToWin = howManyInRowToWin;
        this.finishState = FinishState.NotFinished;
    }


    public FinishState getFinishedState(){
        return finishState;
    }

    public void updateState(BoardData gameBoardData, int fieldNumber) {
        if (fieldNumber == 100)
            finishState = FinishState.OWon;

        if (checkIsWinHorizontally(gameBoardData, fieldNumber))
            finishState = gameBoardData.getSymbolFromField(fieldNumber) == Symbol.X ? FinishState.XWon : FinishState.OWon;

    }

    public boolean checkIsWinHorizontally(BoardData gameBoardData, int fieldNumber) {
        MoveAroundNeighbors moveToRight = new MoveAroundNeighbors(fieldNumber, MoveTo.right);
        int symbolsInRowToTheRight = getHowManyInRow(gameBoardData, moveToRight);

        MoveAroundNeighbors moveToLeft = new MoveAroundNeighbors(fieldNumber, MoveTo.left);
        int symbolsInRowToTheLeft = getHowManyInRow(gameBoardData, moveToLeft);

        return symbolsInRowToTheLeft + 1 + symbolsInRowToTheRight >= howManyInRowToWin;
    }

    public int getHowManyInRow(BoardData gameBoardData, MoveAroundNeighbors boardMove) {
        int howManyInRow = 0;
        Symbol centerFieldSymbol = gameBoardData.getSymbolFromField(boardMove.getCurrentField());
        boardMove.moveIt(gameBoardData);

        while(centerFieldSymbol == gameBoardData.getSymbolFromField(boardMove.getCurrentField())) {
            boardMove.moveIt(gameBoardData);
            ++howManyInRow;
        }

        return howManyInRow;
    }
}
