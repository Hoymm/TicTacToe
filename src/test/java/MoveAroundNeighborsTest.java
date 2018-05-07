import Data.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

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
        boolean moveRightShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 6);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeft_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.left);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 4);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveUp_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.up);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 2);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveDown_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.down);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 8);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightUp_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightUp);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 3);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightDown_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightDown);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 9);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftUp_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftUp);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 1);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftDown_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftDown);
        // when
        finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 7);
    }
    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRight_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.right);
        // when
        boolean moveRightShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveRightShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeft_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.left);
        // when
        boolean moveLeftShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveLeftShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveUp_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.up);
        // when
        boolean moveUpShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveDown_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.down);
        // when
        boolean moveDownShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveDownShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightUp_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightUp);
        // when
        boolean moveRightUpShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveRightUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightDown_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightDown);
        // when
        boolean moveRightDownShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveRightDownShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftUp_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftUp);
        // when
        boolean moveLeftUpShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveLeftUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftDown_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftDown);
        // when
        boolean moveLeftDownShouldReturnTrue = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertTrue(moveLeftDownShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_moveLeft_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(1, MoveTo.left);
        // when
        boolean moveLeftShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveLeftShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_moveUp_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(1, MoveTo.up);
        // when
        boolean moveRightShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_leftUp_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(1, MoveTo.leftUp);
        // when
        boolean moveLeftUpShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveLeftUpShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_RightUp_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(1, MoveTo.rightUp);
        // when
        boolean moveRightUpShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightUpShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs9_Right_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(9, MoveTo.right);
        // when
        boolean moveRightShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs9_Down_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(9, MoveTo.down);
        // when
        boolean moveDownShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveDownShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs9_RightDown_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(9, MoveTo.rightDown);
        // when
        boolean moveRightDownShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightDownShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs9_LeftDown_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(9, MoveTo.leftDown);
        // when
        boolean moveLeftDownShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveLeftDownShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs9_RightUp_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(9, MoveTo.rightUp);
        // when
        boolean moveRightUpShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightUpShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs3_RightDown_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(3, MoveTo.rightDown);
        // when
        boolean moveRightDownShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveRightDownShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs7_LeftUp_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(7, MoveTo.leftUp);
        // when
        boolean moveLeftUpShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveLeftUpShouldReturnFalse);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs1_LeftDown_shouldReturnFalse() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(7, MoveTo.leftDown);
        // when
        boolean moveLeftDownShouldReturnFalse = finishedCheckerMoveDirection.moveItIfPossible(boardData);
        // then
        assertFalse(moveLeftDownShouldReturnFalse);
    }
}
