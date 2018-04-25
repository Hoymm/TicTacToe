package Data;

public class Player {
    private String playerName;
    private int playerScores;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerScores = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this.playerName.equals(((Player)obj).playerName) && this.playerScores == ((Player)obj).playerScores;
    }
}
