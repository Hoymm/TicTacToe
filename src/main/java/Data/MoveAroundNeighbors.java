package Data;

public class MoveAroundNeighbors {
    private int curField;
    private MoveTo directionMove;

    public MoveAroundNeighbors(int centerField, MoveTo directionMove) {
        this.curField = centerField;
        this.directionMove = directionMove;
    }

    public void moveIt(BoardData boardData){
        curField += directionMove.moveX() + directionMove.moveY()*boardData.width;
    }

    public int getCurrentField(){
        return curField;
    }
}
