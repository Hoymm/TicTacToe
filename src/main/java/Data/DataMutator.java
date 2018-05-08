package Data;

public interface DataMutator {
    void changePlayerToOpposite();
    String gameHeaderDisplayInfo();
    String gameBoardDisplayInfo();
    boolean insertGameStartData(String userInput);
    RoundState getRoundState();
    boolean insertNewCoordinates(int userInput);
    String getGameScores();
    void addPointsToPlayer(Symbol symbol);
    boolean isGameFinished();
    void prepareNewRound();
    void addScoresToWinner();
}
