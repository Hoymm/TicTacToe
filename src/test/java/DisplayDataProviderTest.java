import org.testng.annotations.BeforeClass;

public class DisplayDataProviderTest {
    private DisplayDataProvider displayDataProvider;

    @BeforeClass
    public void setUp(){
        displayDataProvider = DataProvider.displayInfo();
    }

}
