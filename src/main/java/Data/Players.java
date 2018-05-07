package Data;

import java.util.Objects;

public class Players {
    private Player playerO;
    private Player playerX;
    private Symbol curSymbolPlays;

    public Players(Player playerO, Player playerX, Symbol startSymbol) {
        this.playerO = playerO;
        this.playerX = playerX;
        this.curSymbolPlays = startSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(playerO, players.playerO) &&
                Objects.equals(playerX, players.playerX) &&
                curSymbolPlays == players.curSymbolPlays;
    }

    @Override
    public int hashCode() {

        return Objects.hash(playerO, playerX, curSymbolPlays);
    }

    @Override
    public String toString() {
            return String.format("%s%s \t %s%s%s"
                    , curSymbolPlays.getColor(playerO), playerO, curSymbolPlays.getColor(playerX), playerX, curSymbolPlays.getDefaultColor());
    }

    public Player getCurrentPlayer() {
        return curSymbolPlays.whoShouldPlay(playerO, playerX);
    }

    public Symbol getCurrentSymbol() {
        return getCurrentPlayer().getSymbol();
    }

    public void changePlayerTurn() {
        curSymbolPlays = curSymbolPlays.getOppositeSymbol();
    }
}
