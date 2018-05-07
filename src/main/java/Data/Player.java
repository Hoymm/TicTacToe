package Data;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerScores == player.playerScores &&
                Objects.equals(playerName, player.playerName) &&
                symbol == player.symbol;
    }

    @Override
    public int hashCode() {

        return Objects.hash(playerName, playerScores, symbol);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]: %d", playerName, symbol, playerScores);
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
