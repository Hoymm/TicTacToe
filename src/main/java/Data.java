public class Data {
    private Players players;
    private GameBoard gameBoard;

    public Data(Players players, GameBoard gameBoard) {
        this.players = players;
        this.gameBoard = gameBoard;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
