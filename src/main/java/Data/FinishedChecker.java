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
        if (isWin(gameBoardData, fieldNumber))
            finishState = gameBoardData.getSymbolFromField(fieldNumber) == Symbol.X ? FinishState.XWon : FinishState.OWon;

    }

    private boolean isWin(BoardData gameBoardData, int fieldNumber) {
        return isWinHorizontally(gameBoardData, fieldNumber) || isWinVertically(gameBoardData, fieldNumber)
                || isWinDiagonally(gameBoardData, fieldNumber);

    }

    public boolean isWinDiagonally(BoardData gameBoardData,  int fieldNumber) {
        return checkWin(gameBoardData, fieldNumber, MoveTo.leftUp, MoveTo.rightDown)
                || checkWin(gameBoardData, fieldNumber, MoveTo.leftDown, MoveTo.rightUp);
    }

    public boolean isWinVertically(BoardData gameBoardData, int fieldNumber) {
        return checkWin(gameBoardData, fieldNumber, MoveTo.up, MoveTo.down);
    }

    public boolean isWinHorizontally(BoardData gameBoardData, int fieldNumber) {
        return checkWin(gameBoardData, fieldNumber, MoveTo.left, MoveTo.right);
    }

    private boolean checkWin(BoardData gameBoardData, int fieldNumber, MoveTo oneSideMove, MoveTo anotherSideMove) {
        MoveAroundNeighbors moveToRight = new MoveAroundNeighbors(fieldNumber, oneSideMove);
        int symbolsInRowToTheRight = getHowManyInRow(gameBoardData, moveToRight);

        MoveAroundNeighbors moveToLeft = new MoveAroundNeighbors(fieldNumber, anotherSideMove);
        int symbolsInRowToTheLeft = getHowManyInRow(gameBoardData, moveToLeft);

        return symbolsInRowToTheLeft + 1 + symbolsInRowToTheRight >= howManyInRowToWin;
    }

    public int getHowManyInRow(BoardData gameBoardData, MoveAroundNeighbors boardMove) {
        int howManyInRow = 0;
        Symbol centerFieldSymbol = gameBoardData.getSymbolFromField(boardMove.getCurrentField());
        boardMove.tryMoveIt(gameBoardData);

        while(centerFieldSymbol == gameBoardData.getSymbolFromField(boardMove.getCurrentField())) {
            boardMove.tryMoveIt(gameBoardData);
            ++howManyInRow;
        }

        return howManyInRow;
    }
}
