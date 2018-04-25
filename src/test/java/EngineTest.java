import org.testng.annotations.*;

public class EngineTest {
    private Engine engine;

    @BeforeClass
    public void createEngine(){
        engine = new Engine();
    }

    @Test
    public void runGame(){
        engine.runGame();
    }
}
