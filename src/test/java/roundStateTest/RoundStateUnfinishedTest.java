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

public class RoundStateUnfinishedTest {
    private RoundState roundStateUnfinished;

    @BeforeMethod
    public void setUp(){
        roundStateUnfinished = new RoundStateUnfinished();
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateUnfinished_shouldReturnTrue() {
        boolean result = roundStateUnfinished.equals(new RoundStateUnfinished());
        assertTrue(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateUnfinished.equals(new RoundStateDraw());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateUnfinished.equals(new RoundStateOWon());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateXWon_shouldReturnFalse() {
        boolean result = roundStateUnfinished.equals(new RoundStateXWon());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateUnfinished.equals(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }

    @Test
    public void getMessageKey_returns_MessageKeys_theRoundWins() {
        assertEquals(roundStateUnfinished.getMessageKey(), MessageKeys.gameUnfinished);
    }

    @Test
    public void addPointsAccordingRoundFinishedState_shouldReturn3to0 () {
        Player playerX, playerO;
        playerX = new Player("Koczkodan", Symbol.X);
        playerO = new Player("Nie Koczkodan", Symbol.O);
        Players players = new Players(playerO, playerX, Symbol.O);

        roundStateUnfinished.addPointsAccordingRoundFinishedState(players);

        assertEquals(playerO.getPlayerScores(), 0);
        assertEquals(playerX.getPlayerScores(), 0);
    }

    @Test
    public void getMessageKeyArguments_returnArgumentsForStringFormat_SymbolX() {
        assertEquals(roundStateUnfinished.getMessageKeyArguments(), new Object[]{});
    }
}
