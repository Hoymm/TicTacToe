import Data.*;
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
        exampleData = new Data("Maciek Wojtek 3 3");
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data("Maciek Wojtek 3 3");
        // then
        Assert.assertEquals(exampleData, expectedData);
    }

    @Test
    public void twoDifferentDataObjects_withDifferentPlayersAndBoard_willBeConsideredDifferent(){
        // given
        // when
        Data expectedData = new Data("Jarek Jakub 3 3");
        // then
        Assert.assertNotEquals(exampleData, expectedData);
    }

    @Test
    public void getGameSettingsFromUser_shouldReturnDataObject(){
        // given
        // when
        // then
        Assert.assertEquals(new Data(userIO.userGameStartInput()), exampleData);
    }
}
