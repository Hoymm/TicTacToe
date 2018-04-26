import UserIO.InputParams;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import Data.*;

public class DisplayDataProviderTest {
    private Data data;
    private CurGameDataInfo displayDataProvider;

    @BeforeClass
    public void setUp(){
        data = new Data(String.format("Maciek%cWojtek%<c3%<c3", InputParams.SEPARATOR));
        displayDataProvider = data.displayInfo();
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers(){
        //given
        //when
        String playersInfo = displayDataProvider.headerInfo();
        //then
        Assert.assertEquals(playersInfo, String.format("%s: %d \t %s: %d", "Maciek", 0, "Wojtek", 0));
    }

    @Test
    public void displayDataProvider_providesInfoAboutBoard(){
        // given
        // when
        String boardToDisplay = displayDataProvider.boardInfo();
        Assert.assertEquals(boardToDisplay, " | | |\n | | |\n | | |\n");
    }

}
