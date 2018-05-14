package roundStateTest;

import data.round.roundState.RoundStateDraw;
import data.round.roundState.RoundStateOWon;
import data.round.roundState.RoundStateUnfinished;
import data.round.roundState.RoundStateXWon;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RoundStateXWonTest {
    private RoundStateXWon roundStateXWon;

    @BeforeMethod
    public void setUp() {
        roundStateXWon = new RoundStateXWon();
    }

    @Test
    public void roundStateXWon_isSameStateAs_roundUnfinished_shouldReturnFalse() {
        boolean result = roundStateXWon.equals(new RoundStateUnfinished());
        assertFalse(result);
    }

    @Test
    public void roundStateXWon_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateXWon.equals(new RoundStateDraw());
        assertFalse(result);
    }

    @Test
    public void roundStateXWon_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateXWon.equals(new RoundStateOWon());
        assertFalse(result);
    }

    @Test
    public void roundStateXWon_isSameStateAs_roundStateXWon_shouldReturnTrue() {
        boolean result = roundStateXWon.equals(new RoundStateXWon());
        assertTrue(result);
    }

    @Test
    public void roundStateXWon_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateXWon.equals(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }
}