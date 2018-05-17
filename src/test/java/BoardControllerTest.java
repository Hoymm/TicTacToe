import data.Symbol;
import data.board.BoardController;
import data.board.BoardData;
import data.round.roundState.RoundStateDraw;
import data.round.roundState.RoundStateXWon;
import data.round.roundState.RoundStateOWon;
import data.round.roundState.RoundStateUnfinished;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardControllerTest {
    private BoardController boardController3x3;
    private BoardData gameBoardData;

    @BeforeMethod
    public void setUp(){
        gameBoardData = Mockito.mock(BoardData.class);
        gameBoardData = new BoardData(3, 3);
        boardController3x3 = new BoardController(gameBoardData, 3);
    }

    @Test
    public void getRoundState_newlyCreatedBoardController_shouldReturn_roundStateUnfinished() {
        assertEquals(boardController3x3.getRoundState(), new RoundStateUnfinished());
    }

    @Test
    public void getRoundState_makeOWinHorizontally_returns_roundStateOWon() {
        putSymbolsOnCoordinates(Symbol.O, 1, 2, 3);
        assertEquals(boardController3x3.getRoundState(), new RoundStateOWon());
    }

    @Test
    public void getRoundState_makeOWinVertically_returns_roundStateOWon() {
        putSymbolsOnCoordinates(Symbol.O, 1, 4, 7);
        assertEquals(boardController3x3.getRoundState(), new RoundStateOWon());
    }

    @Test
    public void getRoundState_makeOWinDiagonalDecreasing_returns_roundStateOWon() {
        putSymbolsOnCoordinates(Symbol.O, 1, 5, 9);
        assertEquals(boardController3x3.getRoundState(), new RoundStateOWon());
    }

    @Test
    public void getRoundState_makeOWinDiagonalIncreasing_returns_roundStateOWon() {
        putSymbolsOnCoordinates(Symbol.O, 3, 5, 7);
        assertEquals(boardController3x3.getRoundState(), new RoundStateOWon());
    }

    @Test
    public void getRoundState_makeXWinHorizontally_returns_roundStateXWon() {
        putSymbolsOnCoordinates(Symbol.X, 1, 2, 3);
        assertEquals(boardController3x3.getRoundState(), new RoundStateXWon());
    }

    @Test
    public void getRoundState_makeXWinVertically_returns_roundStateXWon() {
        putSymbolsOnCoordinates(Symbol.X, 1, 4, 7);
        assertEquals(boardController3x3.getRoundState(), new RoundStateXWon());
    }

    @Test
    public void getRoundState_makeXWinDiagonalDecreasing_returns_roundStateXWon() {
        putSymbolsOnCoordinates(Symbol.X, 1, 5, 9);
        assertEquals(boardController3x3.getRoundState(), new RoundStateXWon());
    }

    @Test
    public void getRoundState_makeXWinDiagonalIncreasing_returns_roundStateXWon() {
        putSymbolsOnCoordinates(Symbol.X, 3, 5, 7);
        assertEquals(boardController3x3.getRoundState(), new RoundStateXWon());
    }

    @Test
    public void getRoundState_doNotFinishRound_returns_roundUnfinishedState() {
        putSymbolsOnCoordinates(Symbol.X, 3, 7);
        putSymbolsOnCoordinates(Symbol.O, 5);
        assertEquals(boardController3x3.getRoundState(), new RoundStateUnfinished());
    }

    @Test
    public void getRoundState_putSymbolsToMakeDraw_returns_roundStateDraw() {
        putSymbolsOnBoard3x3ToMakeADraw();
        assertEquals(boardController3x3.getRoundState(), new RoundStateDraw());
    }

    @Test
    public void prepareNewRound_putSymbolsToMakeBoardFull_returns_nullForEachFieldSymbolGet() {
        putSymbolsOnBoard3x3ToMakeADraw();
        boardController3x3.prepareNewRound();
        boolean result = isGetSymbolFromFieldsShouldAlwaysReturnNull(1,2,3,4,5,6,7,8,9);
        assertTrue(result);
    }

    @Test
    public void prepareNewRound_makeADraw_returns_RoundStateUnfinished() {
        putSymbolsOnBoard3x3ToMakeADraw();
        boardController3x3.prepareNewRound();
        assertEquals(boardController3x3.getRoundState(), new RoundStateUnfinished());
    }

    private boolean isGetSymbolFromFieldsShouldAlwaysReturnNull(int... fieldNumbers){
        for (int i : fieldNumbers) {
            if (gameBoardData.getSymbolFromField(i) != null) {
                return false;
            }
        }
        return true;
    }

    private void putSymbolsOnBoard3x3ToMakeADraw(){
        putSymbolsOnCoordinates(Symbol.X, 2, 5, 7, 9);
        putSymbolsOnCoordinates(Symbol.O, 1, 3, 4, 6, 8);
    }

    private void putSymbolsOnCoordinates(Symbol symbol, Integer... fieldNumbers){
        putSymbolsOnCoordinates(boardController3x3, symbol, fieldNumbers);
    }

    private void putSymbolsOnCoordinates(BoardController boardController, Symbol symbol, Integer... fieldNumbers) {
        for (int i : fieldNumbers)
            boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(i, symbol);

    }
}
