import Data.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FinishedCheckerTest {
    private final static int howManyInRowToWin = 3;
    private FinishedChecker finishedChecker;
    private BoardController boardController;
    private BoardData boardData;

    @BeforeMethod
    public void setUp() {
        finishedChecker = new FinishedChecker(howManyInRowToWin);
        boardData = new BoardData(3,3);
        boardController = new BoardController(boardData, howManyInRowToWin);
    }

    @Test
    public void onBoard3x3_markOFields135_XFields24_nobodyWinsAGame(){
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.O);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(2, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(3, Symbol.O);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(4, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(5, Symbol.O);
        // then
        assertFalse(finishedChecker.isWin(boardData, 5));
    }

    @Test
    public void onBoard3x3_mark123WithSymbolX_checkIsWinHorizontallyShouldReturnTrue() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(2, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(3, Symbol.X);
        // then
        assertTrue(finishedChecker.isWinHorizontally(boardData, 3));
    }

    @Test
    public void onBoard3x3_mark12WithSymbolX_checkIsWinHorizontallyShouldReturnFalse() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(2, Symbol.X);
        // then
        assertFalse(finishedChecker.isWinHorizontally(boardData, 2));
    }


    @Test
    public void onBoard3x3_mark147WithSymbolX_checkIsWinVerticallyShouldReturnTrue() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(4, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(7, Symbol.X);
        // then
        assertTrue(finishedChecker.isWinVertically(boardData, 7));
    }


    @Test
    public void onBoard3x3_mark14WithSymbolX_checkIsWinVerticallyShouldReturnFalse() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(4, Symbol.X);
        // then
        assertFalse(finishedChecker.isWinVertically(boardData, 4));
    }

    @Test
    public void onBoard3x3_mark159WithSymbolX_checkIsWinDiagonallyShouldReturnTrue() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(5, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(9, Symbol.X);
        // then
        assertTrue(finishedChecker.isWinDiagonally(boardData, 9));
    }

    @Test
    public void onBoard3x3_mark159WithSymbolX_checkIsWinDiagonallyShouldReturnFalse() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(5, Symbol.X);
        // then
        assertFalse(finishedChecker.isWinDiagonally(boardData, 5));
    }

    @Test
    public void onBoard3x3_mark357WithSymbolX_checkIsWinDiagonallyShouldReturnTrue() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(3, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(5, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(7, Symbol.X);
        // then
        assertTrue(finishedChecker.isWinDiagonally(boardData, 7));
    }

    @Test
    public void onBoard3x3_mark37WithSymbolX_checkIsWinDiagonallyShouldReturnFalse() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(3, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(7, Symbol.X);
        // then
        assertFalse(finishedChecker.isWinDiagonally(boardData, 7));
    }

    @Test
    public void onBoard3x3_markAllFields_checkIsADrawReturnTrue() {
        // given
        // when
        for (int i = 0; i <= 9; ++i)
            boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(i, Symbol.X);
        // then
        assertTrue(finishedChecker.isDraw(boardData));
    }

    @Test
    public void onBoard3x3_mark2Fields_checkIsADrawReturnFalse() {
        // given
        // when
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(1, Symbol.X);
        boardController.tryMarkFieldAndChangeWinnerStateIfNeeded(5, Symbol.O);
        // then
        assertFalse(finishedChecker.isDraw(boardData));
    }

}
