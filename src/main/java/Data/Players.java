package Data;

public class Players {
    private Player player1;
    private Player player2;

    public Players(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean equals(Object obj) {
        return player1.equals(((Players)obj).player1) && player2.equals(((Players)obj).player2);
    }
}
