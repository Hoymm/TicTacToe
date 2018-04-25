public class Engine {
    private DataProvider dataProvider;
    private PlayGame playGame;
    private InfoDisplayer infoDisplayer;
    private UserIO userIO;

    public Engine(DataProvider dataProvider, PlayGame playGame, InfoDisplayer infoDisplayer, UserIO userIO) {
        this.dataProvider = dataProvider;
        this.playGame = playGame;
        this.infoDisplayer = infoDisplayer;
        this.userIO = userIO;
    }


    public void runGame() {
        //dataProvider = new DataProvider(userIO.getGameSettingsFromUser());
    }
}
