package Data;

public class Player {
    private String playerName;
    private int playerScores;

    public Player(String playerName, int playerScores) {
        this.playerName = playerName;
        this.playerScores = playerScores;
    }

    @Override
    public boolean equals(Object obj) {
        return this.playerName.equals(((Player)obj).playerName) && this.playerScores == ((Player)obj).playerScores;
    }
}
