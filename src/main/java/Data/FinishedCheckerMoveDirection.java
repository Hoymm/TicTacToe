package Data;

public class FinishedCheckerMoveDirection {
    private int curField;
    private int moveX;
    private int moveY;

    public FinishedCheckerMoveDirection(int centerField, int moveX, int moveY) {
        this.curField = centerField;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public void moveIt(BoardData boardData){
        curField += moveX + moveY*boardData.width;
    }

    public int getCurrentField(){
        return curField;
    }
}
