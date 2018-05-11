import Data.*;
import Data.Messenger.Messenger;
import GameState.UserIO.InputParams;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserIOTest {
    private Data exampleData;
    private Messenger messenger;

    @BeforeClass
    public void setUp(){
        Messenger messenger = Mockito.mock(Messenger.class);
        exampleData = new Data(String.format("Maciek%sWojtek%<sO%<s3%<s3%<s3", InputParams.SEPARATOR), messenger);
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data(String.format("Maciek%sWojtek%<sO%<s3%<s3%<s3", InputParams.SEPARATOR), messenger);
        // then
        assertEquals(exampleData, expectedData);
    }

    @Test
    public void twoDifferentDataObjects_withDifferentPlayersAndBoard_willBeConsideredDifferent(){
        // given
        // when

        Data expectedData = new Data(String.format("Jarek%sJakub%<sO%<s3%<s3%<s3", InputParams.SEPARATOR), messenger);
        // then
        assertNotEquals(exampleData, expectedData);
    }
}
