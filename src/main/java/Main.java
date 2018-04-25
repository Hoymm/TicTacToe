public class Main {
    public static void main(String[] args) {
        UserIO userIO = new UserIO();
        Data data = userIO.getGameSettingsFromUser();
        DataProvider dataProvider = new DataProvider(data);
        PlayGame playGame = new PlayGame();
        InfoDisplayer infoDisplayer = new InfoDisplayer();

        Engine engine = new Engine(dataProvider, playGame, infoDisplayer, userIO);
        engine.runGame();
    }
}
