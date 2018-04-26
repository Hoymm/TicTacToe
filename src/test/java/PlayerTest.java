import Data.Player;
import Data.Symbol;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayerTest {
    private Player playerKasia2;

    @BeforeTest
    public void setUp(){
        playerKasia2 = new Player("Kasia", Symbol.X);
    }

    @Test
    public void twoSameNameAndScoresPlayers_shouldBeConsideredEqual(){
        // given
        // when
        Player anotherPlayerKasia2 = new Player("Kasia", Symbol.X);
        // then
        assertEquals(playerKasia2, anotherPlayerKasia2);
    }

    @Test
    public void twoDifferentNamePlayers_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Bartek", Symbol.X);
        // then
        assertNotEquals(playerKasia2, anotherPlayerBartek1);
    }
}
