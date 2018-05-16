package roundStateTest;

import data.Symbol;
import data.players.Player;
import data.players.Players;
import data.round.roundState.RoundStateDraw;
import data.round.roundState.RoundStateOWon;
import data.round.roundState.RoundStateUnfinished;
import data.round.roundState.RoundStateXWon;
import messenger.MessageKeys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RoundStateDrawTest {
    private RoundStateDraw roundStateDraw;
    @BeforeMethod
    public void setUp() {
        roundStateDraw = new RoundStateDraw();
    }

    @Test
    public void roundStateDraw_isSameStateAs_roundUnfinished_shouldReturnFalse() {
        boolean result = roundStateDraw.equals(new RoundStateUnfinished());
        assertFalse(result);
    }

    @Test
    public void roundStateDraw_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateDraw.equals(new RoundStateDraw());
        assertTrue(result);
    }

    @Test
    public void roundStateDraw_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateDraw.equals(new RoundStateOWon());
        assertFalse(result);
    }

    @Test
    public void roundStateDraw_isSameStateAs_RoundStateXWon_shouldReturnTrue() {
        boolean result = roundStateDraw.equals(new RoundStateXWon());
        assertFalse(result);
    }

    @Test
    public void roundStateDraw_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateDraw.equals(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }

    @Test
    public void getMessageKey_returns_MessageKeys_roundIsFinishedWithDraw() {
        assertEquals(roundStateDraw.getMessageKey(), MessageKeys.roundIsFinishedWithDraw);
    }

    @Test
    public void addPointsAccordingRoundFinishedState_shouldReturnOnePointForEachPlayer () {
        Player playerX, playerO;
        playerX = new Player("Koczkodan", Symbol.X);
        playerO = new Player("Nie Koczkodan", Symbol.O);
        Players players = new Players(playerO, playerX, Symbol.O);

        roundStateDraw.addPointsAccordingRoundFinishedState(players);

        assertEquals(playerX.getPlayerScores(), 1);
        assertEquals(playerO.getPlayerScores(), 1);
    }

    @Test
    public void stringFormatArgumentsShouldReturnAnEmptyArray() {
        assertEquals(roundStateDraw.getMessageKeyArguments(), new Object[]{});
    }
}
