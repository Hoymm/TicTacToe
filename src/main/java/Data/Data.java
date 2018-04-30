package Data;

import GameState.UserIO.InputParams;

public class Data {
    private Players players;
    private GameBoard gameBoard;

    public Data(){
    }

    public Data(String userInput) {
        insertGameStartData(userInput);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Data)) {
            return false;
        }
        return players.equals(((Data)obj).players);
    }

    public String gameHeaderDisplayInfo() {
        return players.toString();
    }

    public String gameBoardDisplayInfo() {
        return gameBoard.toString();
    }

    public CurGameDataMutator getDataMutator(){
        return new CurGameDataMutator() {
            @Override
            public void changePlayerToOpposite() {
                players.changePlayerTurn();
            }
        };
    }

    public void insertGameStartData(String userInput) {
            String [] userInputArray = userInput.split(InputParams.SEPARATOR);
            this.players = new Players(new Player(userInputArray[0], Symbol.O), new Player(userInputArray[1], Symbol.X), Symbol.valueOf(userInputArray[2]));
            this.gameBoard = new GameBoard(Integer.valueOf(userInputArray[3]), Integer.valueOf(userInputArray[4]));
    }

    public boolean insertNewCoordinates(int userInput){
        return gameBoard.markField(userInput, players.getCurrentSymbol());
    }
}
