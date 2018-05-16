package roundStateTest;

import data.Symbol;
import data.players.Player;
import data.players.Players;
import data.round.roundState.*;
import messenger.MessageKeys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RoundStateOWonTest {
    private RoundStateOWon roundStateOWon;

    @BeforeMethod
    public void setUp() {
        roundStateOWon = new RoundStateOWon();
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateOWon_shouldReturnTrue() {
        boolean result = roundStateOWon.equals(new RoundStateUnfinished());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateOWon.equals(new RoundStateDraw());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateOWon.equals(new RoundStateOWon());
        assertTrue(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateXWon_shouldReturnFalse() {
        boolean result = roundStateOWon.equals(new RoundStateXWon());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateOWon.equals(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }

    @Test
    public void getMassageKey_returns_MessageKeys_theRoundWins() {
        assertEquals(roundStateOWon.getMessageKey(), MessageKeys.theRoundWins);
    }

    @Test
    public void addPointsAccordingRoundFinishedState_shouldReturn3to0 () {
        Player playerX, playerO;
        playerX = new Player("Koczkodan", Symbol.O);
        playerO = new Player("Nie Koczkodan", Symbol.X);
        Players players = new Players(playerO, playerX, Symbol.O);

        roundStateOWon.addPointsAccordingRoundFinishedState(players);

        assertEquals(playerO.getPlayerScores(), 3);
        assertEquals(playerX.getPlayerScores(), 0);
    }

    @Test
    public void getMessageKeyArguments_returnArgumentsForStringFormat_SymbolO() {
        assertEquals(roundStateOWon.getMessageKeyArguments(), new Object[]{Symbol.O});
    }
}