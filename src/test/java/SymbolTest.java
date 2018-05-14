import data.Colors;
import data.players.Player;
import data.Symbol;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SymbolTest {
    private Player kasiaO, wojtekX;
    private Symbol symbolO, symbolX;

    @BeforeMethod
    public void setUp (){
        symbolO = Symbol.O;
        symbolX = Symbol.X;
        kasiaO = new Player("Kasia", Symbol.O);
        wojtekX = new Player("Wojtek", Symbol.X);
    }

    @Test
    public void whenCurrentSymbolPlayIsO_afterAskWhoShouldPlayNow_itShouldReturnReferenceKasiaO(){
        // given
        // when
        Player playerToPlay = symbolO.whoShouldPlay(kasiaO, wojtekX);
        // then
        assertSame(playerToPlay, kasiaO);
    }

    @Test
    public void whenCurrentSymbolPlayIsX_afterAskWhoShouldPlayNow_itShouldReturnReferenceWojtekX(){
        // given
        // when
        Player playerToPlay = symbolX.whoShouldPlay(kasiaO, wojtekX);
        // then
        assertSame(playerToPlay, wojtekX);
    }

    @Test
    public void whenCurrentSymbolPlayIsX_afterAskWhoShouldPlayNow_itShouldAssertThatCurrentPlayerIsNotAReferenceToKasiaO(){
        // given
        // when
        Player playerToPlay = symbolX.whoShouldPlay(kasiaO, wojtekX);
        // then
        assertNotSame(playerToPlay, kasiaO);
    }

    @Test
    public void ifPlayerHasTheSameColorAsSymbol_returnedColorShouldBeActive (){
        // given
        // when
        Colors shouldBeActive = symbolO.getColor(kasiaO);
        // then
        assertEquals(shouldBeActive, Colors.ACTIVE);
    }

    @Test
    public void symbolO_changeToOppositeSymbol_shouldReturnSymbolX (){
        // given
        // when
        symbolO = symbolO.getOppositeSymbol();
        // then
        assertEquals(symbolO, symbolX);
    }

    @Test
    public void symbolX_changeToOppositeSymbol_shouldReturnSymbolO (){
        // given
        // when
        symbolX = symbolX.getOppositeSymbol();
        // then
        assertEquals(symbolX, symbolO);
    }
}
