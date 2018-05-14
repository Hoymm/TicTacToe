package roundStateTest;

import data.round.roundState.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
}
