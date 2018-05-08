import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Data.*;

import static org.testng.Assert.assertEquals;

public class DisplayDataProviderTest {
    private Data data;

    @BeforeClass
    public void setUp(){
        data = new Data();
        data.insertGameStartData("Maciek Wojtek O 3 10 10");
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers_providesProperPattern(){
        //given
        //when
        String playersInfo = data.gameHeaderDisplayInfo();
        //then
        assertEquals(playersInfo, String.format("%s%s [%s]: %d \t %s%s [%s]: %d%s",
                Colors.ACTIVE, "Maciek", Symbol.O, 0, Colors.INACTIVE , "Wojtek", Symbol.X, 0, Colors.DEFAULT));
    }


    // TODO create test cheking board format display

}
