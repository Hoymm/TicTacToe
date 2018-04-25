import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DisplayDataProviderTest {
    private DataProvider dataProvider;
    private DisplayDataProvider displayDataProvider;

    @BeforeClass
    public void setUp(){
        dataProvider = new DataProvider(new Players(new Player("Maciek", 2), new Player("Wojtek", 3)));
        displayDataProvider = dataProvider.displayInfo();
    }

    @Test
    public void displayDataProvider_providesInfoAboutPlayers(){
        //given
        //when
        String playersInfo = displayDataProvider.playersInfo();
        //then
        Assert.assertEquals(String.format("%s: %d \t %s: %d", "Maciek", 2, "Wojtek", 3), playersInfo);
    }

}
