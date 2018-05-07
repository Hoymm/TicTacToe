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
        if (isDraw(gameBoardData))
            finishState = FinishState.Draw;
        else if (isWin(gameBoardData, fieldNumber))
            finishState = gameBoardData.getSymbolFromField(fieldNumber) == Symbol.X ? FinishState.XWon : FinishState.OWon;
    }


    public boolean isDraw(BoardData gameBoardData) {
        return gameBoardData.isBoardFull();
    }

    public boolean isWin(BoardData gameBoardData, int fieldNumber) {
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
        int symbolsInRowOneSide = getHowManyInRow(gameBoardData, new BoardNeighborsWinChecker(fieldNumber, oneSideMove));

        // TODO remove that
        if (fieldNumber == 6 && oneSideMove == MoveTo.leftDown && anotherSideMove == MoveTo.rightUp)
            System.out.println("ABRA KADABRA !! !!! !!!!");

        int symbolsInRowAnotherSide = getHowManyInRow(gameBoardData, new BoardNeighborsWinChecker(fieldNumber, anotherSideMove));

        return symbolsInRowAnotherSide + 1 + symbolsInRowOneSide >= howManyInRowToWin;
    }


    public int getHowManyInRow(BoardData gameBoardData, BoardNeighborsWinChecker boardNeighborsChecker) {
        int howManyInRow = 0;
        Symbol centerFieldSymbol = gameBoardData.getSymbolFromField(boardNeighborsChecker.getCurrentField());

        while(boardNeighborsChecker.moveItIfPossible(gameBoardData)
                && centerFieldSymbol == gameBoardData.getSymbolFromField(boardNeighborsChecker.getCurrentField()))
            ++howManyInRow;

        return howManyInRow;
    }
}
