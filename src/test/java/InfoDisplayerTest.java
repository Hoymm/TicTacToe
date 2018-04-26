import Data.CurGameStateInfo;
import UserIO.UserIO;
import org.testng.annotations.BeforeClass;


public class InfoDisplayerTest {
    private InfoDisplayerTest infoDisplayerTest;

    private CurGameStateInfo displayDataProvider;
    private UserIO userIO;

    @BeforeClass
    public void setUp(){
        infoDisplayerTest = new InfoDisplayerTest();
    }
}