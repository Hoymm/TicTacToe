public class DataProvider implements DisplayDataProvider {
    public DataProvider(Players players) {

    }

    public DisplayDataProvider displayInfo() {
        return this;
    }

    public String playersInfo() {
        return "Maciek: 2 \t Wojtek: 3";
    }
}
