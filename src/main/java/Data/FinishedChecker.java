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
        FinishedCheckerMoveDirection directionMoveToRight = new FinishedCheckerMoveDirection(fieldNumber,1, 0);
        int symbolsInRowToTheRight = getHowManyInRow(gameBoardData, directionMoveToRight);

        FinishedCheckerMoveDirection directionMoveToLeft = new FinishedCheckerMoveDirection(fieldNumber,-1, 0);
        int symbolsInRowToTheLeft = getHowManyInRow(gameBoardData, directionMoveToLeft);

        return symbolsInRowToTheLeft + 1 + symbolsInRowToTheRight >= howManyInRowToWin;
    }

    public int getHowManyInRow(BoardData gameBoardData, FinishedCheckerMoveDirection boardMove) {
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
