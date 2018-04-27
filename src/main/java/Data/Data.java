package Data;

import GameState.GameState;
import GameState.RunningGameState;
import GameState.StartGameState;
import GameState.UserIO.InputParams;

public class Data {
    private Players players;
    private GameBoard gameBoard;

    public Data(){
    }

    public Data(String userInput) {
        applyUserInput(userInput, new StartGameState());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Data)) {
            return false;
        }
        return players.equals(((Data)obj).players);
    }

    public CurGameDataInfo getInfoToDisplay() {
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

    public CurGameDataMutator getDataMutator(){
        return new CurGameDataMutator() {
            @Override
            public void changePlayerToOpposite() {
                players.changePlayerTurn();
            }
        };
    }

    public void applyUserInput(String userInput, GameState gameState) {
        if (gameState instanceof StartGameState) {
            String [] userInputArray = userInput.split(InputParams.SEPARATOR);
            this.players = new Players(new Player(userInputArray[0], Symbol.O), new Player(userInputArray[1], Symbol.X), Symbol.valueOf(userInputArray[2]));
            this.gameBoard = new GameBoard(Integer.valueOf(userInputArray[3]), Integer.valueOf(userInputArray[4]));
        }
        else if (gameState instanceof RunningGameState){
            // TODO modify state
            System.out.println("I am in running state");
        }
    }
}
