import org.testng.annotations.*;

public class EngineTest {
    private Engine engine;

    private UserIO userIO;
    private PlayGame playGame;
    private DataProvider dataProvider;
    private InfoDisplayer infoDisplayer;

    @BeforeClass
    public void createEngine(){
        Data data = new Data(new Players(new Player("Maciek", 2), new Player("Wojtek", 3)), new GameBoard(3, 3));

        DataProvider dataProvider = new DataProvider(data);
        userIO = new UserIO();
        playGame = new PlayGame();
        infoDisplayer = new InfoDisplayer();

        engine = new Engine(dataProvider, playGame, infoDisplayer, userIO);
    }

    @Test
    public void runGame(){
        engine.runGame();
    }
}
