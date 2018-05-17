import data.Data;
import data.Symbol;
import gameState.userIO.startSettingsInput.StartSettings;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DataTest {
    private Data data;

    @BeforeMethod
    public void setUp(){
        StartSettings exampleStartSettings = getExampleStartSettings();
        data = new Data(exampleStartSettings);
    }

    @Test
    public void getSymbolToPlayNow_afterInsertedOToPlayFirst_returnSymbolO(){
        Symbol whichSymbolTurn = data.getSymbolToPlayNow();
        assertEquals(whichSymbolTurn, Symbol.O);
    }

    @Test
    public void getSymbolToPlayNow_afterInsertedOToPlayFirst_doNotReturnSymbolX(){
        Symbol whichSymbolTurn = data.getSymbolToPlayNow();
        assertNotEquals(whichSymbolTurn, Symbol.X);
    }

    private StartSettings getExampleStartSettings() {
        StartSettings startSettings = new StartSettings();
        startSettings.boardHeight = 3;
        startSettings.boardWidth = 3;
        startSettings.howManySymbolsInARowToWinRound = 3;
        startSettings.namePlayerO = "Karol";
        startSettings.namePlayerX = "Krzysiek";
        startSettings.whoStartsFirst = Symbol.O;
        return startSettings;
    }
}
