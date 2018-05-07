import Data.BoardController;
import Data.BoardData;
import Data.Symbol;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GameBoardTest {
    private BoardController gameBoard;

    @BeforeMethod
    public void setUp (){
        BoardData gameBoardData = new BoardData(10, 10);
        gameBoard = new BoardController(gameBoardData, 3);
    }

    @Test
    public void onEmptyBoard10x10_markXOn100_shouldResultTrue (){
        // given
        // when
        boolean fieldMarked = gameBoard.tryMarkField(100, Symbol.X);
        // then
        assertTrue(fieldMarked);
    }

    @Test
    public void onEmptyBoard10x10_markXOn101_shouldResultFalse (){
        // given
        // when
        boolean fieldMarked = gameBoard.tryMarkField(101, Symbol.X);
        // then
        assertFalse(fieldMarked);
    }

    @Test
    public void onEmptyBoard10x10_markXOn0_shouldResultFalse (){
        // given
        // when
        boolean fieldMarked = gameBoard.tryMarkField(0, Symbol.X);
        // then
        assertFalse(fieldMarked);
    }
}
