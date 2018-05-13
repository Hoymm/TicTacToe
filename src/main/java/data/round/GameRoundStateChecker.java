package data.round;
import data.board.BoardData;
import data.board.BoardNeighborsWinChecker;
import data.Symbol;

public class GameRoundStateChecker {
    final private int howManyInRowToWin;
    private RoundState roundState;

    public GameRoundStateChecker(int howManyInRowToWin) {
        this.howManyInRowToWin = howManyInRowToWin;
        this.roundState = RoundState.Unfinished;
    }


    public RoundState getRoundState(){
        return roundState;
    }

    public void updateState(BoardData gameBoardData, int fieldNumber) {
        if (isWin(gameBoardData, fieldNumber)) {
            roundState = gameBoardData.getSymbolFromField(fieldNumber) == Symbol.X ? RoundState.XWon : RoundState.OWon;
        } else if (isDraw(gameBoardData)){
            roundState = RoundState.Draw;
        }
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
        int middleFieldPoint = 1;

        int symbolsInRowToOneSide = getHowManyInRow(gameBoardData, new BoardNeighborsWinChecker(fieldNumber, oneSideMove));
        int symbolsInRowToAnotherSide = getHowManyInRow(gameBoardData, new BoardNeighborsWinChecker(fieldNumber, anotherSideMove));
        return symbolsInRowToOneSide + middleFieldPoint + symbolsInRowToAnotherSide >= howManyInRowToWin;
    }


    private int getHowManyInRow(BoardData gameBoardData, BoardNeighborsWinChecker boardNeighborsChecker) {
        int howManyInRow = 0;
        Symbol centerFieldSymbol = gameBoardData.getSymbolFromField(boardNeighborsChecker.getCurrentField());

        while(boardNeighborsChecker.moveItIfPossible(gameBoardData)
                && centerFieldSymbol == gameBoardData.getSymbolFromField(boardNeighborsChecker.getCurrentField()))
            ++howManyInRow;

        return howManyInRow;
    }

    public void setStateUnfinished() {
        roundState = RoundState.Unfinished;
    }
}
