package Data;

public class MoveAroundNeighbors {
    private int curField;
    private MoveTo directionMove;

    public MoveAroundNeighbors(int centerField, MoveTo directionMove) {
        this.curField = centerField;
        this.directionMove = directionMove;
    }

    public boolean tryMoveIt(BoardData boardData){
        curField += directionMove.moveX() + directionMove.moveY()*boardData.width;
        return true;
    }

    public int getCurrentField(){
        return curField;
    }
}
