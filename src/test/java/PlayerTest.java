import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayerTest {
    private Player playerKasia2;

    @BeforeClass
    public void setUp(){
        playerKasia2 = new Player("Kasia", 2);
    }

    @Test
    public void twoSameNameAndScoresPlayers_shouldBeConsideredEqual(){
        // given
        // when
        Player anotherPlayerKasia2 = new Player("Kasia", 2);
        // then
        Assert.assertEquals(playerKasia2, anotherPlayerKasia2);
    }

    @Test
    public void twoDifferentNamePlayers_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Bartek", 1);
        // then
        Assert.assertNotEquals(playerKasia2, anotherPlayerBartek1);
    }
}
