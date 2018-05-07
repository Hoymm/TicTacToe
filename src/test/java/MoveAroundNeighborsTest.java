import Data.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class MoveAroundNeighborsTest {
    private BoardData boardData;

    @BeforeMethod
    public void setUp() {
        // given
        boardData = new BoardData(3,3);
        // when
        // then
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRight_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.right);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 6);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeft_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.left);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 4);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveUp_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.up);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 2);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveDown_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.down);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 8);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightUp_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightUp);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 3);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightDown_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightDown);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 9);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftUp_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftUp);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 1);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftDown_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftDown);
        // when
        finishedCheckerMoveDirection.moveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 7);
    }
}
