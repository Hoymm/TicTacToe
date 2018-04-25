import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import Data.*;

public class DisplayDataProviderTest {
    private Data data;
    private DisplayInfoProvider displayDataProvider;

    @BeforeClass
    public void setUp(){
        data = new Data("Maciek Wojtek 3 3");
        displayDataProvider = data.getDisplayInfoProvider();
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers(){
        //given
        //when
        String playersInfo = displayDataProvider.headerInfo();
        //then
        Assert.assertEquals(String.format("%s: %d \t %s: %d", "Maciek", 2, "Wojtek", 3), playersInfo);
    }

    @Test
    public void displayDataProvider_providesInfoAboutBoard(){
        // given
        // when
        String boardToDisplay = displayDataProvider.boardInfo();
        Assert.assertEquals(boardToDisplay, " | | |\n | | |\n | | |\n");
    }

}
