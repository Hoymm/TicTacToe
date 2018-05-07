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
        boolean moveRightShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 6);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeft_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.left);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 4);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveUp_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.up);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 2);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveDown_shouldResultInField6AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.down);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 8);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightUp_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightUp);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 3);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightDown_shouldResultInField9AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightDown);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 9);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftUp_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftUp);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 1);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftDown_moveYBy1_shouldResultInField7AfterMoving() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftDown);
        // when
        finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertEquals(finishedCheckerMoveDirection.getCurrentField(), 7);
    }
    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRight_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.right);
        // when
        boolean moveRightShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveRightShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeft_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.left);
        // when
        boolean moveLeftShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveLeftShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveUp_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.up);
        // when
        boolean moveUpShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveDown_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.down);
        // when
        boolean moveDownShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveDownShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightUp_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightUp);
        // when
        boolean moveRightUpShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveRightUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveRightDown_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.rightDown);
        // when
        boolean moveRightDownShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveRightDownShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftUp_moveYBy1_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftUp);
        // when
        boolean moveLeftUpShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveLeftUpShouldReturnTrue);
    }

    @Test
    public void moveOnBoard3x3_startFieldIs5_moveLeftDown_moveYBy1_shouldReturnTrue() {
        // given
        MoveAroundNeighbors finishedCheckerMoveDirection = new MoveAroundNeighbors(5, MoveTo.leftDown);
        // when
        boolean moveLeftDownShouldReturnTrue = finishedCheckerMoveDirection.tryMoveIt(boardData);
        // then
        assertTrue(moveLeftDownShouldReturnTrue);
    }
}
