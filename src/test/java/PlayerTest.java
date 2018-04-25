import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlayerTest {
    private Player playerKasia2;

    @BeforeTest
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
    public void twoDifferentNamePlayersAndSameScores_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Bartek", 2);
        // then
        Assert.assertNotEquals(playerKasia2, anotherPlayerBartek1);
    }

    @Test
    public void twoSameNamePlayersAndDifferentScores_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Kasia", 1);
        // then
        Assert.assertNotEquals(playerKasia2, anotherPlayerBartek1);
    }
}
