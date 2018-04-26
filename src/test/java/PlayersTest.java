import Data.Player;
import Data.Players;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

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
        assertEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheFirstDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Wiktor"), new Player("Kasia"));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheSecondDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian"), new Player("Filip"));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWitDifferentNames_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Grzegorz"), new Player("Filip"));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void test(){
        assertEquals(examplePlayers.toString(), "Adrian: 0 \t Kasia: 0");
    }
}
