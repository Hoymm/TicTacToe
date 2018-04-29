package Data;

public class Player {
    private String playerName;
    private int playerScores;
    private Symbol symbol;

    public Player(String playerName, Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerScores = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Player)) {
            return false;
        }
        return this.playerName.equals(((Player)obj).playerName) && this.playerScores == ((Player)obj).playerScores;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]: %d", playerName, symbol, playerScores);
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
