import Data.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FinishedCheckerTest {
    // TODO uncomment and go on with TDD here
    final static int howManyInRowToWin = 3;
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
    public void onBoard3x3_mark123WithSymbolX_checkIsWinHorizontallyShouldReturnTrue() {
        // given
        // when
        boardController.tryMarkField(1, Symbol.X);
        boardController.tryMarkField(2, Symbol.X);
        int lastInputField = 3;
        boardController.tryMarkField(lastInputField, Symbol.X);
        // then
        assertTrue(finishedChecker.checkIsWinHorizontally(boardData, lastInputField));
        //assertEquals(boardController.getFinishedState(), FinishState.XWon);
    }

    @Test
    public void onBoard3x3_mark12WithSymbolX_checkIsWinHorizontallyShouldReturnFalse() {
        // given
        // when
        boardController.tryMarkField(1, Symbol.X);
        int lastInputField = 2;
        boardController.tryMarkField(lastInputField, Symbol.X);
        // then
        assertFalse(finishedChecker.checkIsWinHorizontally(boardData, lastInputField));
    }

}
