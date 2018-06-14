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
        return boardDrawer.calculateStringDisplayingGameBoard(gameBoardData);
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
