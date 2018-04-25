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

        Players players = new Players(new Player("Maciek", 2), new Player("Wojtek", 3));
        GameBoard gameBoard = new GameBoard(3, 3);
        exampleData = new Data(players, gameBoard);
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        Players players1 = new Players(new Player("Maciek", 2), new Player("Wojtek", 3));
        GameBoard gameBoard1 = new GameBoard(3, 3);
        // when
        Data expectedData = new Data(players1, gameBoard1);
        // then
        Assert.assertEquals(exampleData, expectedData);
    }

    @Test
    public void twoDifferentDataObjects_withDifferentPlayersAndBoard_willBeConsideredDifferent(){
        // given
        Players players1 = new Players(new Player("Krzysiek", 2), new Player("Jakub", 3));
        GameBoard gameBoard1 = new GameBoard(3, 3);
        // when
        Data expectedData = new Data(players1, gameBoard1);
        // then
        Assert.assertNotEquals(exampleData, expectedData);
    }

    @Test
    public void getGameSettingsFromUser_shouldReturnDataObject(){
        // given
        // when
        // then
        Assert.assertEquals(userIO.loadGameSettingsFromUser(), exampleData);
    }
}
