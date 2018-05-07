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
        int symbolsInRowOneSide = getHowManyInRow(gameBoardData, new MoveAroundNeighbors(fieldNumber, oneSideMove));

        // TODO remove that
        if (fieldNumber == 5 && oneSideMove == MoveTo.leftDown && anotherSideMove == MoveTo.rightUp)
            System.out.println("5");

        int symbolsInRowAnotherSide = getHowManyInRow(gameBoardData, new MoveAroundNeighbors(fieldNumber, anotherSideMove));

        return symbolsInRowAnotherSide + 1 + symbolsInRowOneSide >= howManyInRowToWin;
    }


    public int getHowManyInRow(BoardData gameBoardData, MoveAroundNeighbors boardMove) {
        int howManyInRow = 0;
        Symbol centerFieldSymbol = gameBoardData.getSymbolFromField(boardMove.getCurrentField());
        boardMove.moveItIfPossible(gameBoardData);

        while(centerFieldSymbol == gameBoardData.getSymbolFromField(boardMove.getCurrentField())) {
            ++howManyInRow;
            boardMove.moveItIfPossible(gameBoardData);
        }

        return howManyInRow;
    }
}
