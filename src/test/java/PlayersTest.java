import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayersTest {
    private Players examplePlayers;

    @BeforeClass
    public void setUp(){
        examplePlayers = new Players(new Player("Adrian", 2), new Player("Kasia", 3));
    }


    @Test
    public void twoPlayersObject_shouldBeConsideredEqualsIfTheir_playerValuesAreEqual(){
        // given
        Players players = new Players(new Player("Adrian", 2), new Player("Kasia", 3));
        // when
        // then
        Assert.assertEquals(examplePlayers, players);
    }
}
