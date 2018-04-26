import Data.CurGameDataInfo;
import UserIO.UserIO;
import org.testng.annotations.BeforeClass;


public class InfoDisplayerTest {
    private InfoDisplayerTest infoDisplayerTest;

    private CurGameDataInfo displayDataProvider;
    private UserIO userIO;

    @BeforeClass
    public void setUp(){
        infoDisplayerTest = new InfoDisplayerTest();
    }
}