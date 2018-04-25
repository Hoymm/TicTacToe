import Data.Player;
import Data.Players;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlayersTest {
    private Players examplePlayers;

    @BeforeTest
    public void setUp(){
        examplePlayers = new Players(new Player("Adrian", 2), new Player("Kasia", 3));
    }


    @Test
    public void twoPlayersWithTheSameNamesAndScores_shouldBeConsiderEqual(){
        // given
        Players players = new Players(new Player("Adrian", 2), new Player("Kasia", 3));
        // when
        // then
        Assert.assertEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheSameNamesAndDifferentScores_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian", 2), new Player("Kasia", 1));
        // when
        // then
        Assert.assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithDifferentNamesAndSameScores_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian", 2), new Player("Wojtek", 3));
        // when
        // then
        Assert.assertNotEquals(examplePlayers, players);
    }
}
