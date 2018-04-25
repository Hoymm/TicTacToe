package Data;

public class DataProvider {

    private Data data;

    public DataProvider(Data data) {
        this.data = data;
    }

    public DisplayInfoProvider displayInfo() {
        return new DisplayInfoProvider() {
            @Override
            public String headerInfo() {
                return "Maciek: 2 \t Wojtek: 3";
            }

            @Override
            public String boardInfo() {
                StringBuilder tableDisplayInfoBuilder = new StringBuilder();
                for (int width = 0; width < 3; ++width) {
                    for (int height = 0; height < 3; ++height)
                        tableDisplayInfoBuilder.append(" ").append("|");
                    tableDisplayInfoBuilder.append("\n");
                }
                return tableDisplayInfoBuilder.toString();
            }
        };
    }
}
