import messenger.Messenger;
import gameState.userIO.startSettingsInput.StartSettingsLoader;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.*;

import static org.testng.Assert.assertEquals;

public class DisplayDataProviderTest {
    private Data data;
    @Mock
    private Messenger messenger;

    @BeforeClass
    public void setUp(){
        messenger = Mockito.mock(Messenger.class);
        data = new Data(StartSettingsLoader.loadExampleData());
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers_providesProperPattern(){
        //given
        //when
        String playersInfo = data.gameHeaderDisplayInfo();
        //then
        assertEquals(playersInfo, String.format("%s%s [%s]: %d \t %s%s [%s]: %d%s",
                Colors.ACTIVE, "Damian", Symbol.O, 0, Colors.INACTIVE , "Andrzej", Symbol.X, 0, Colors.DEFAULT));
    }
}
