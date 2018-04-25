import Data.Data;
import Data.DataProvider;
import InfoDisplayer.InfoDisplayer;
import PlayGame.PlayGame;
import UserIO.UserIO;

public class Main {
    public static void main(String[] args) {
        UserIO userIO = new UserIO();
        Data data = userIO.loadGameSettingsFromUser();
        DataProvider dataProvider = new DataProvider(data);
        PlayGame playGame = new PlayGame();
        InfoDisplayer infoDisplayer = new InfoDisplayer();

        Engine engine = new Engine(dataProvider, playGame, infoDisplayer, userIO);
        engine.runGame();
    }
}
