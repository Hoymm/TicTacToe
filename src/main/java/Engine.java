public class Engine {
    private DisplayDataProvider displayDataProvider;
    private PlayGame playGame;
    private InfoDisplayer infoDisplayer;
    private UserIO userIO;

    public Engine(DisplayDataProvider dataProvider, PlayGame playGame, InfoDisplayer infoDisplayer, UserIO userIO) {
        this.displayDataProvider = dataProvider;
        this.playGame = playGame;
        this.infoDisplayer = infoDisplayer;
        this.userIO = userIO;
    }

    public void runGame() {
        displayDataProvider = new DataProvider(userIO.getGameSettingsFromUser()).displayInfo();
        for (int i = 0; i < 3; ++i){
            System.out.println(displayDataProvider.playersInfo());
            System.out.println(displayDataProvider.boardInfo());
        }
    }
}
