import data.Colors;
import data.Symbol;
import data.players.Player;
import data.players.Players;
import messenger.Messenger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class PlayersTest {
    private Player adrianO, kasiaX;
    private Players examplePlayersXStarts, examplePlayersOStarts;
    private Messenger messenger;

    @BeforeMethod
    public void setUp(){
        adrianO = new Player("Adrian", Symbol.O);
        kasiaX = new Player("Kasia", Symbol.X);
        examplePlayersXStarts = new Players(adrianO, kasiaX, Symbol.X);
        examplePlayersOStarts = new Players(adrianO, kasiaX, Symbol.O);
        messenger = new Messenger(Locale.ENGLISH, System.out::println);
    }


    @Test
    public void twoPlayersWithTheSameNames_shouldBeConsiderEqual(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Kasia", Symbol.X), Symbol.X);
        // when
        // then
        assertEquals(examplePlayersXStarts, players);
    }

    @Test
    public void twoPlayersWithTheFirstDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Wiktor", Symbol.O), new Player("Kasia", Symbol.X), Symbol.X);
        // when
        // then
        assertNotEquals(examplePlayersXStarts, players);
    }

    @Test
    public void twoPlayersWithTheSecondDifferentName_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Adrian", Symbol.O), new Player("Filip", Symbol.X), Symbol.X);
        // when
        // then
        assertNotEquals(examplePlayersXStarts, players);
    }

    @Test
    public void twoPlayersWitDifferentNames_shouldBeConsiderDifferent(){
        // given
        Players players = new Players(new Player("Grzegorz", Symbol.O), new Player("Filip", Symbol.X), Symbol.X);
        // when
        // then
        assertNotEquals(examplePlayersXStarts, players);
    }

    @Test
    public void testPlayerOutput_doesItMatchPattern(){

        //then
        assertEquals(examplePlayersXStarts.toString(), String.format("%s%s [%s]: %d \t %s%s [%s]: %d%s",
                Colors.INACTIVE, "Adrian", Symbol.O, 0, Colors.ACTIVE , "Kasia", Symbol.X, 0, Colors.DEFAULT));
    }

    @Test
    public void whenGetCurPlayer_itShouldReturnReferenceToKasiaX(){
        // Given
        // when
        Player curPlayer = examplePlayersXStarts.getCurrentPlayer();
        // then
        assertSame(curPlayer, kasiaX);
    }

    @Test
    public void whenGetCurPlayer_itShouldReturnReferenceNotToAdrian(){
        // Given
        // when
        Player curPlayer = examplePlayersXStarts.getCurrentPlayer();
        // then
        assertNotSame(curPlayer, adrianO);
    }

    @Test
    public void whenchangePlayerTurnWhenKasiaPlays_itShouldReturnReferenceToAdrianO(){
        // given
        // when
        examplePlayersXStarts.changePlayerTurn();
        // then
        assertSame(examplePlayersXStarts.getCurrentPlayer(), adrianO);
    }

    @Test
    public void getCurrentSymbol_createPlayersWhereXStarts_ReturnSymbolX() {
        assertEquals(examplePlayersXStarts.getCurrentSymbol(), Symbol.X);
    }

    @Test
    public void getCurrentSymbol_createPlayersWhereOStarts_ReturnSymbolO() {
        assertEquals(examplePlayersOStarts.getCurrentSymbol(), Symbol.O);
    }

    @Test
    public void addScoresToO_whenAdd3PointsToOPlayer_returns3Points() {
        examplePlayersOStarts.addScoresToO(3);
        assertEquals(adrianO.getPlayerScores(), 3);
    }

    @Test
    public void addScoresToX_whenAdd3PointsToXPlayer_returns3Points() {
        examplePlayersXStarts.addPointsToX(3);
        assertEquals(kasiaX.getPlayerScores(), 3);
    }

    @Test
    public void gameFinishedMessage_playerHaveTheSameScores_returnsDrawMessage() {
        assertEquals(examplePlayersOStarts.showGameFinishedMessage(messenger), "Game finished with draw !");
    }

    @Test
    public void gameFinishedMessage_playerXMoreScores_returnsXWonMessage() {
        kasiaX.addPoints(3);
        assertEquals(String.format("The winner is %s. %s: %d %s: %d", kasiaX.getSymbol()
                , adrianO.getSymbol(), adrianO.getPlayerScores(), kasiaX.getSymbol(), kasiaX.getPlayerScores()),
                examplePlayersOStarts.showGameFinishedMessage(messenger));
    }

    @Test
    public void gameFinishedMessage_playerOMoreScores_returnsOWonMessage() {
        kasiaX.addPoints(3);
        adrianO.addPoints(4);
        assertEquals(String.format("The winner is %s. %s: %d %s: %d", adrianO.getSymbol()
                , adrianO.getSymbol(), adrianO.getPlayerScores(), kasiaX.getSymbol(), kasiaX.getPlayerScores()),
                examplePlayersOStarts.showGameFinishedMessage(messenger));
    }

    @Test
    public void whoStartedLastRound_startSettingsToXStart_returnSymbolX(){
        assertEquals(examplePlayersXStarts.whoStartedLastRound(), Symbol.X);
    }

    @Test
    public void setCurrentPlayerToOneWhoStartsRound_aftersetWhoStartedLastRoundToOpposite_returnSymbolO(){
        examplePlayersXStarts.setWhoStartedLastRoundToOpposite();
        examplePlayersXStarts.setCurrentPlayerToOneWhoStartsRound();
        assertEquals(examplePlayersXStarts.whoStartedLastRound(), Symbol.O);
    }
}
