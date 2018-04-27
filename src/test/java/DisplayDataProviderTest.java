import GameState.UserIO.InputParams;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Data.*;

import static org.testng.Assert.assertEquals;

public class DisplayDataProviderTest {
    private Data data;
    private CurGameDataInfo displayDataProvider;

    @BeforeClass
    public void setUp(){
        data = new Data(String.format("Maciek%sWojtek%<sO%<s3%<s3", InputParams.SEPARATOR));
        displayDataProvider = data.getInfoToDisplay();
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers_providesProperPattern(){
        //given
        //when
        String playersInfo = displayDataProvider.headerInfo();
        //then
        assertEquals(playersInfo, String.format("%s%s [%s]: %d \t %s%s [%s]: %d%s",
                Colors.ACTIVE, "Maciek", Symbol.O, 0, Colors.INACTIVE , "Wojtek", Symbol.X, 0, Colors.DEFAULT));
    }

}
