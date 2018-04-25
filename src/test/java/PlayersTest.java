import Data.Player;
import Data.Players;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlayersTest {
    private Players examplePlayers;

    @BeforeTest
    public void setUp(){
        examplePlayers = new Players(new Player("Adrian"), new Player("Kasia"));
    }


    @Test
    public void twoPlayersWithTheSameNames_shouldBeConsiderEqual(){
        // given
        Players players = new Players(new Player("Adrian"), new Player("Kasia"));
        // when
        // then
        Assert.assertEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheFirstDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Wiktor"), new Player("Kasia"));
        // when
        // then
        Assert.assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheSecondDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian"), new Player("Filip"));
        // when
        // then
        Assert.assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWitDifferentNames_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Grzegorz"), new Player("Filip"));
        // when
        // then
        Assert.assertNotEquals(examplePlayers, players);
    }
}
