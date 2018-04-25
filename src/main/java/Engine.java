import Data.DataProvider;
import Data.DisplayInfoProvider;
import InfoDisplayer.InfoDisplayer;
import PlayGame.PlayGame;
import UserIO.UserIO;

public class Engine {
    private DisplayInfoProvider displayInfoProvider;
    private PlayGame playGame;
    private InfoDisplayer infoDisplayer;
    private UserIO userIO;

    public Engine(DataProvider dataProvider, PlayGame playGame, InfoDisplayer infoDisplayer, UserIO userIO) {
        this.displayInfoProvider = dataProvider.displayInfo();
        this.playGame = playGame;
        this.infoDisplayer = infoDisplayer;
        this.userIO = userIO;
    }

    public void runGame() {
        displayInfoProvider = new DataProvider(userIO.loadGameSettingsFromUser()).displayInfo();
        for (int i = 0; i < 3; ++i){
            System.out.println(displayInfoProvider.headerInfo());
            System.out.println(displayInfoProvider.boardInfo());
        }
    }
}
