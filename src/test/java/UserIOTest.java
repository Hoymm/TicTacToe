import data.*;
import messenger.Messenger;
import gameState.userIO.startSettingsInput.StartSettingsLoader;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserIOTest {
    private Data exampleData;

    @Mock
    private Messenger messenger;

    @BeforeClass
    public void setUp(){
        Messenger messenger = Mockito.mock(Messenger.class);
        exampleData = new Data(StartSettingsLoader.loadExampleData());
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data(StartSettingsLoader.loadExampleData());
        // then
        assertEquals(exampleData, expectedData);
    }
}
