package roundStateTest;

import data.round.roundState.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        boolean result = roundStateOWon.isSameStateAs(new RoundStateUnfinished());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateOWon.isSameStateAs(new RoundStateDraw());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateOWon.isSameStateAs(new RoundStateOWon());
        assertTrue(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_roundStateXWon_shouldReturnFalse() {
        boolean result = roundStateOWon.isSameStateAs(new RoundStateXWon());
        assertFalse(result);
    }

    @Test
    public void roundStateOWon_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateOWon.isSameStateAs(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }
}