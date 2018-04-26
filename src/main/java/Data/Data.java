package Data;

public class Data {
    private Players players;
    private GameBoard gameBoard;

    public Data(String userInput) {
        String [] userInputArray = userInput.split(";");
        this.players = new Players(new Player(userInputArray[0]), new Player(userInputArray[1]));
        this.gameBoard = new GameBoard(Integer.valueOf(userInputArray[2]), Integer.valueOf(userInputArray[3]));
    }

    @Override
    public boolean equals(Object obj) {
        return players.equals(((Data)obj).players) && gameBoard.equals(((Data)obj).gameBoard);
    }

    public CurGameDataInfo displayInfo() {
        return new CurGameDataInfo() {
            @Override
            public String headerInfo() {
                return players.toString();
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
