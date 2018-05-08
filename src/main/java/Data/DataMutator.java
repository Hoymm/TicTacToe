package Data;

public interface DataMutator {
    void changePlayerToOpposite();
    String gameHeaderDisplayInfo();
    String gameBoardDisplayInfo();
    boolean insertGameStartData(String userInput);
    RoundState getRoundState();
    boolean insertNewCoordinates(int userInput);
    boolean isGameFinished();
    void prepareNewRound();
    void addNewPointsToPlayers();
    void incrementRoundsPlayed();
    String gameFinishResult();
}
