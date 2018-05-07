import Data.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class FinishedCheckerMoveDirectionTest {
    private BoardData boardData;

    @BeforeMethod
    public void setUp() {
        // given
        boardData = new BoardData(3,3);
        // when
        // then
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveXBy1_moveYBy0_shouldResultInField6AfterMoving() {
        // given
        FinishedCheckerMoveDirection finishedCheckerMoveDirection = new FinishedCheckerMoveDirection(5, 1, 0);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 6);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_moveXBy1_moveYBy1_shouldResultInField5AfterMoving() {
        // given
        FinishedCheckerMoveDirection finishedCheckerMoveDirection = new FinishedCheckerMoveDirection(1, 1, 1);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 5);
    }

    @Test ()
    public void test() {
        // given
        FinishedCheckerMoveDirection finishedCheckerMoveDirection = new FinishedCheckerMoveDirection(0, -1, 1);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 5);
    }
}
