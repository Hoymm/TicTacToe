import Data.*;
import UserIO.InputParams;
import UserIO.UserIO;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserIOTest {
    private UserIO userIO;
    private Data exampleData;

    @BeforeClass
    public void setUp(){
        userIO = new UserIO();
        exampleData = new Data(String.format("Maciek%cWojtek%<c3%<c3", InputParams.SEPARATOR));
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data(String.format("Maciek%cWojtek%<c3%<c3", InputParams.SEPARATOR));
        // then
        Assert.assertEquals(exampleData, expectedData);
    }

    @Test
    public void twoDifferentDataObjects_withDifferentPlayersAndBoard_willBeConsideredDifferent(){
        // given
        // when

        Data expectedData = new Data(String.format("Jarek%cJakub%<c3%<c3", InputParams.SEPARATOR));
        // then
        Assert.assertNotEquals(exampleData, expectedData);
    }
}
