package Data;

import java.util.Objects;

public class Players {
    private Player playerO;
    private Player playerX;
    private Symbol curSymbolPlays;
    private Messenger messenger;

    public Players(Player playerO, Player playerX, Symbol startSymbol, Messenger messenger) {
        this.playerO = playerO;
        this.playerX = playerX;
        this.curSymbolPlays = startSymbol;
        this.messenger = messenger;
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

    public void addPointsToX(int points) {
        playerX.addPoints(points);
    }

    public void addPointsToO(int points) {
        playerO.addPoints(points);
    }

    public String gameFinishedMessage() {
        if (playerO.getPlayerScores() == playerX.getPlayerScores())
            return messenger.translateKey(MessageKeys.gameFinishedItsADraw);
        else {
            Player winner = playerO.getPlayerScores() > playerX.getPlayerScores() ? playerO : playerX;
            return String.format(messenger.translateKey(MessageKeys.winsWhoAndScores)
                    , winner.getSymbol(), playerO.getSymbol(), playerO.getPlayerScores(), playerX.getSymbol(), playerX.getPlayerScores());
        }
    }
}
