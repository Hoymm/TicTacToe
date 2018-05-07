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
        int howManySymbolsInRow = 0;
        Symbol checkingSymbol = gameBoardData.getSymbolFromField(fieldNumber);
        return true;
    }
}
