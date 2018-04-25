import org.testng.annotations.*;

public class EngineTest {
    private Engine engine;

    private UserIO userIO;
    private PlayGame playGame;
    private DataProvider dataProvider;
    private InfoDisplayer infoDisplayer;

    @BeforeTest
    public void createEngine() {
        userIO = new UserIO();
        Data data = userIO.getGameSettingsFromUser();
        dataProvider = new DataProvider(data);
        playGame = new PlayGame();
        infoDisplayer = new InfoDisplayer();

        engine = new Engine(dataProvider, playGame, infoDisplayer, userIO);
    }
}
