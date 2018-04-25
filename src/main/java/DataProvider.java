public class DataProvider implements DisplayDataProvider {

    private Data data;

    public DataProvider(Data data) {
        this.data = data;
    }

    public DisplayDataProvider displayInfo() {
        return this;
    }

    public String playersInfo() {
        return "Maciek: 2 \t Wojtek: 3";
    }

    public String boardInfo() {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        for (int width = 0; width < 3; ++width) {
            for (int height = 0; height < 3; ++height)
                tableDisplayInfoBuilder.append(" ").append("|");
            tableDisplayInfoBuilder.append("\n");
        }
        return tableDisplayInfoBuilder.toString();
    }
}
