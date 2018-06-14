import data.Colors;
import data.Data;
import data.Symbol;
import gameState.userIO.startSettingsInput.StartSettingsLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DisplayDataProviderTest {
    private Data data;

    @BeforeClass
    public void setUp(){
        data = new Data(StartSettingsLoader.loadExampleData());
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers_providesProperPattern(){
        //given
        //when
        String playersInfo = data.gameHeaderDisplayInfo();
        //then
        String expected = String.format("%s%s%s [%s]: %d \t %s%s%s [%s]: %d",
                Colors.ACTIVE, "Damian", Colors.INACTIVE, Symbol.O, 0
                , Colors.INACTIVE, "Andrzej", Colors.INACTIVE, Symbol.X, 0);
        assertEquals(playersInfo, expected);
    }
}
