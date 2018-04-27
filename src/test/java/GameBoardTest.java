import Data.GameBoard;
import Data.Symbol;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeMethod
    public void setUp (){
        gameBoard = new GameBoard(10, 10);
    }

    @Test
    public void onEmptyBoard10x10_markXOn100_shouldResultTrue (){
        // given
        // when
        boolean fieldMarked = gameBoard.markField(100, Symbol.X);
        // then
        assertTrue(fieldMarked);
    }

    @Test
    public void onEmptyBoard10x10_markXOn101_shouldResultFalse (){
        // given
        // when
        boolean fieldMarked = gameBoard.markField(101, Symbol.X);
        // then
        assertFalse(fieldMarked);
    }

    @Test
    public void onEmptyBoard10x10_markXOn0_shouldResultFalse (){
        // given
        // when
        boolean fieldMarked = gameBoard.markField(0, Symbol.X);
        // then
        assertFalse(fieldMarked);
    }
}
