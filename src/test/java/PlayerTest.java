import Data.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayerTest {
    private Player playerKasia2;

    @BeforeTest
    public void setUp(){
        playerKasia2 = new Player("Kasia");
    }

    @Test
    public void twoSameNameAndScoresPlayers_shouldBeConsideredEqual(){
        // given
        // when
        Player anotherPlayerKasia2 = new Player("Kasia");
        // then
        assertEquals(playerKasia2, anotherPlayerKasia2);
    }

    @Test
    public void twoDifferentNamePlayers_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Bartek");
        // then
        assertNotEquals(playerKasia2, anotherPlayerBartek1);
    }
}
