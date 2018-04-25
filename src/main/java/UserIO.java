public class UserIO {

    public Data getGameSettingsFromUser() {
        return new Data(new Players(new Player("Maciek", 2), new Player("Wojtek", 3)), new GameBoard(3, 3));
    }
}
