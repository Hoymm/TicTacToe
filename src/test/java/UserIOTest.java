import data.*;
import gameState.userIO.startSettingsInput.StartSettingsLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserIOTest {
    private Data exampleData;

    @BeforeClass
    public void setUp(){
        exampleData = new Data(StartSettingsLoader.loadExampleData());
    }

    @Test
    public void twoDifferentDataObjects_withTheSamePlayersAndBoard_willBeConsideredEqual(){
        // given
        // when
        Data expectedData = new Data(StartSettingsLoader.loadExampleData());
        // then
        assertEquals(exampleData, expectedData);
    }
}
