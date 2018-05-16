import data.players.Player;
import data.Symbol;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayerTest {
    private Player playerKasiaX;

    @BeforeMethod
    public void setUp(){
        playerKasiaX = new Player("Kasia", Symbol.X);
    }

    @Test
    public void twoSameNameAndScoresPlayers_shouldBeConsideredEqual(){
        // given
        // when
        Player anotherPlayerKasia2 = new Player("Kasia", Symbol.X);
        // then
        assertEquals(playerKasiaX, anotherPlayerKasia2);
    }

    @Test
    public void twoDifferentNamePlayers_shouldBeConsideredNotEqual(){
        // given
        // when
        Player anotherPlayerBartek1 = new Player("Bartek", Symbol.X);
        // then
        assertNotEquals(playerKasiaX, anotherPlayerBartek1);
    }

    @Test
    public void getPlayerScores_newPlayer_shouldReturn0Points() {
        assertEquals(playerKasiaX.getPlayerScores(), 0);
    }

    @Test
    public void getPlayerScores_newPlayerAdd3Points_shouldReturn3Points() {
        playerKasiaX.addPoints(3);
        assertEquals(playerKasiaX.getPlayerScores(), 3);
    }

    @Test
    public void getSymbol_newPlayerWithX_shouldReturnSymbolX() {
        assertEquals(playerKasiaX.getSymbol(), Symbol.X);
    }

    @Test
    public void getSymbol_newPlayerWithO_shouldReturnSymbolO() {
        Player playerO = new Player("Kacper", Symbol.O);
        assertEquals(playerO.getSymbol(), Symbol.O);
    }
}
