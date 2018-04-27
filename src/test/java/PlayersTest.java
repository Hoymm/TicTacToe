import Data.Player;
import Data.Players;
import Data.Symbol;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayersTest {
    private Players examplePlayers;

    @BeforeTest
    public void setUp(){
        examplePlayers = new Players(new Player("Adrian", Symbol.O), new Player("Kasia", Symbol.X));
    }


    @Test
    public void twoPlayersWithTheSameNames_shouldBeConsiderEqual(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Kasia", Symbol.X));
        // when
        // then
        assertEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheFirstDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Wiktor", Symbol.O), new Player("Kasia", Symbol.X));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheSecondDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Filip", Symbol.X));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWitDifferentNames_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Grzegorz", Symbol.O), new Player("Filip", Symbol.X));
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void test(){
        assertEquals(examplePlayers.toString(), String.format("%s [%s]: %d \t %s [%s]: %d", "Adrian", Symbol.O, 0, "Kasia", Symbol.X, 0));
    }
}
