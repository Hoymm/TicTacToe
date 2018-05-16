package data.players;

import data.Symbol;

import java.util.Objects;

public class Player {
    final private String playerName;
    private int playerScores;
    final private Symbol symbol;

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
    public String toString() {
        return String.format("%s [%s]: %d", playerName, symbol, playerScores);
    }

    public Symbol getSymbol(){
        return symbol;
    }

    int getPlayerScores() {
        return playerScores;
    }

    void addPoints(int points) {
        playerScores += points;
    }
}
