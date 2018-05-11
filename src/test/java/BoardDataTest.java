import Data.Board.BoardData;
import Data.Symbol;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardDataTest {
    private BoardData boardData;

    @BeforeMethod
    public void setUp() {
        boardData = new BoardData(10,10);
    }

    @Test
    public void add100FieldsTo10x10Board_isBoardFull_shouldReturnTrue() {
        // given
        // when
        for (int i = 1; i < 100; i+=2){
            boardData.putSymbolToField(Symbol.X, i);
            boardData.putSymbolToField(Symbol.O, i+1);
        }
        // then
        assertTrue(boardData.isBoardFull());
    }

    @Test
    public void addFewFieldsTo10x10Board_isBoardFull_shouldReturnFalse() {
        // given
        // when
        for (int i = 1; i < 5; i+=2){
            boardData.putSymbolToField(Symbol.X, i);
            boardData.putSymbolToField(Symbol.O, i+1);
        }
        // then
        assertFalse(boardData.isBoardFull());
    }
}
