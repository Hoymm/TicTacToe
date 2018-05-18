import data.Data;
import gameState.states.RunningGameState;
import gameState.userIO.startSettingsInput.StartSettingsLoader;
import messenger.Messenger;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunningGameStateTest {
    private RunningGameState runningGameState;

    @Mock
    private Messenger messenger;
    @Mock
    private Data data;

    @BeforeMethod
    public void setUp(){
        messenger = Mockito.mock(Messenger.class);
        data = new Data();
        data.insertGameStartData(StartSettingsLoader.loadExampleData());
        runningGameState = new RunningGameState(data, messenger);
    }

    @Test
    public void runningGameState_getNextState_whenStart_returnState_RunningGameState() {
        assertEquals(runningGameState.getNextState().getClass().getName(), RunningGameState.class.getName());
    }
}
