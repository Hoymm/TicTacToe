package Data;

public class MoveAroundNeighbors {
    private int curField;
    private MoveTo directionMove;

    public MoveAroundNeighbors(int centerField, MoveTo directionMove) {
        this.curField = centerField;
        this.directionMove = directionMove;
    }

    public boolean tryMoveIt(BoardData boardData){
        boolean leaveBoardHorizontallyRight = curField%boardData.width == 0 && directionMove.moveX() == 1;
        boolean leaveBoardHorizontallyLeft = curField%boardData.width <= 1 && directionMove.moveX() == -1;
        boolean leaveBoardVerticallyTop = curField <= boardData.width && directionMove.moveY() == -1;
        boolean leaveBoardVerticallyBottom = curField >= boardData.width*(boardData.height-1) && directionMove.moveY() == 1;

        curField += directionMove.moveX() + directionMove.moveY() * boardData.width;

        return !(leaveBoardHorizontallyLeft || leaveBoardHorizontallyRight || leaveBoardVerticallyTop || leaveBoardVerticallyBottom);
    }

    private boolean isInBoardBorders(BoardData boardData) {
        return curField <= boardData.width*boardData.height && curField >= 1;
    }

    public int getCurrentField(){
        return curField;
    }
}
