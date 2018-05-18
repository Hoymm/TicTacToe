package data.players;
import messenger.MessageKeys;
import messenger.Messenger;
import data.Symbol;
import java.util.Objects;

public class Players {
    final private Player playerO, playerX;
    private Symbol curSymbolPlays, whoStartsRound;

    public Players(Player playerO, Player playerX, Symbol startSymbol) {
        this.playerO = playerO;
        this.playerX = playerX;
        this.curSymbolPlays = startSymbol;
        this.whoStartsRound = startSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(playerO, players.playerO) &&
                Objects.equals(playerX, players.playerX) &&
                curSymbolPlays == players.curSymbolPlays &&
                Objects.equals(playerX, players.playerX);
    }

    @Override
    public String toString() {
            return String.format("%s \t %s", playerO.getColoredFormat(curSymbolPlays::getColor), playerX.getColoredFormat(curSymbolPlays::getColor));
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

    public void addScoresToO(int points) {
        playerO.addPoints(points);
    }

    public String showGameFinishedMessage(Messenger messenger) {
        if (playerO.getPlayerScores() == playerX.getPlayerScores())
            return messenger.translateKey(MessageKeys.gameFinishedItsADraw);
        else {
            Player winner = playerO.getPlayerScores() > playerX.getPlayerScores() ? playerO : playerX;
            return String.format(messenger.translateKey(MessageKeys.winsWhoAndScores)
                    , winner.getSymbol(), playerO.getSymbol(), playerO.getPlayerScores()
                    , playerX.getSymbol(), playerX.getPlayerScores());
        }
    }


    public Symbol whoStartedLastRound() {
        return whoStartsRound;
    }

    public void setCurrentPlayerToOneWhoStartsRound(){
        curSymbolPlays = whoStartsRound;
    }

    public void setWhoStartedLastRoundToOpposite() {
        whoStartsRound = whoStartsRound.getOppositeSymbol();
    }
}
