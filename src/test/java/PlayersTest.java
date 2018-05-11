import Data.*;
import Data.Messenger.Messenger;
import Data.Players.Player;
import Data.Players.Players;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayersTest {
    private Player adrianO;
    private Players examplePlayers;
    private Player kasiaX;
    private Messenger messenger;

    @BeforeMethod
    public void setUp(){
        adrianO = new Player("Adrian", Symbol.O);
        kasiaX = new Player("Kasia", Symbol.X);
        examplePlayers = new Players(adrianO, kasiaX, Symbol.X, messenger);
    }


    @Test
    public void twoPlayersWithTheSameNames_shouldBeConsiderEqual(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Kasia", Symbol.X), Symbol.X, messenger);
        // when
        // then
        assertEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheFirstDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Wiktor", Symbol.O), new Player("Kasia", Symbol.X), Symbol.X, messenger);
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWithTheSecondDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Filip", Symbol.X), Symbol.X, messenger);
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void twoPlayersWitDifferentNames_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Grzegorz", Symbol.O), new Player("Filip", Symbol.X), Symbol.X, messenger);
        // when
        // then
        assertNotEquals(examplePlayers, players);
    }

    @Test
    public void testPlayerOutput_doesItMatchPattern(){

        //then
        assertEquals(examplePlayers.toString(), String.format("%s%s [%s]: %d \t %s%s [%s]: %d%s",
                Colors.INACTIVE, "Adrian", Symbol.O, 0, Colors.ACTIVE , "Kasia", Symbol.X, 0, Colors.DEFAULT));
    }

    @Test
    public void whenGetCurPlayer_itShouldReturnReferenceToKasiaX(){
        // Given
        // when
        Player curPlayer = examplePlayers.getCurrentPlayer();
        // then
        assertSame(curPlayer, kasiaX);
    }

    @Test
    public void whenGetCurPlayer_itShouldReturnReferenceNotToAdrian(){
        // Given
        // when
        Player curPlayer = examplePlayers.getCurrentPlayer();
        // then
        assertNotSame(curPlayer, adrianO);
    }

    @Test
    public void whenchangePlayerTurnWhenKasiaPlays_itShouldReturnReferenceToAdrianO(){
        // given
        // when
        examplePlayers.changePlayerTurn();
        // then
        assertSame(examplePlayers.getCurrentPlayer(), adrianO);
    }
}
