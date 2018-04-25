public class Player {
    private String playerName;
    private int playerScores;

    public Player(String playerName, int playerScores) {
        this.playerName = playerName;
        this.playerScores = playerScores;
    }

    @Override
    public boolean equals(Object obj) {
        return playerName.equals(((Player)obj).playerName) && playerScores == ((Player)obj).playerScores;
    }
}
