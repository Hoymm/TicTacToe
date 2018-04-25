package UserIO;

import Data.Data;
import Data.*;

public class UserIO {

    public Data loadGameSettingsFromUser() {
        return new Data(new Players(new Player("Maciek", 2), new Player("Wojtek", 3)), new GameBoard(3, 3));
    }
}
