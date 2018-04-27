import Data.*;
import UserIO.InputParams;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class UserIOTest {
    private Data exampleData;

    @BeforeClass
    public void setUp(){
        exampleData = new Data(String.format("Maciek%cWojtek%<cO%<c3%<c3", InputParams.SEPARATOR));
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data(String.format("Maciek%cWojtek%<cO%<c3%<c3", InputParams.SEPARATOR));
        // then
        assertEquals(exampleData, expectedData);
    }

    @Test
    public void twoDifferentDataObjects_withDifferentPlayersAndBoard_willBeConsideredDifferent(){
        // given
        // when

        Data expectedData = new Data(String.format("Jarek%cJakub%<cO%<c3%<c3", InputParams.SEPARATOR));
        // then
        assertNotEquals(exampleData, expectedData);
    }
}
