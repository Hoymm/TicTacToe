package Data;

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
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Players)) {
            return false;
        }
        return playerO.equals(((Players)obj).playerO) && playerX.equals(((Players)obj).playerX);
    }

    @Override
    public String toString() {
            return String.format("%s%s \t %s%s%s"
                    , curSymbolPlays.getColor(playerO), playerO, curSymbolPlays.getColor(playerX), playerX, curSymbolPlays.getDefaultColor());
    }

    public Player getCurrentPlayer() {
        return curSymbolPlays.whoShouldPlay(playerO, playerX);
    }

    public void changePlayerTurn() {
        curSymbolPlays = curSymbolPlays.getOppositeSymbol();
    }
}
