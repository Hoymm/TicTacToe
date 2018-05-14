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
        boolean result = roundStateUnfinished.isSameStateAs(new RoundStateUnfinished());
        assertTrue(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateDraw_shouldReturnFalse() {
        boolean result = roundStateUnfinished.isSameStateAs(new RoundStateDraw());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateOWon_shouldReturnFalse() {
        boolean result = roundStateUnfinished.isSameStateAs(new RoundStateOWon());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_roundStateXWon_shouldReturnFalse() {
        boolean result = roundStateUnfinished.isSameStateAs(new RoundStateXWon());
        assertFalse(result);
    }

    @Test
    public void roundStateUnfinished_isSameStateAs_null_shouldReturnFalse() {
        boolean nullRoundStateEqualToUnfinishedFalse = roundStateUnfinished.isSameStateAs(null);
        assertFalse(nullRoundStateEqualToUnfinishedFalse);
    }
}
