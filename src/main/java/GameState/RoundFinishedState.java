package GameState;
import Data.Messeger;
import Data.Data;

public class RoundFinishedState extends Game {
    public RoundFinishedState(Data data, Messeger messeger) {
        super(data, messeger);
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        return true;
    }

    @Override
    public Game getNextState() {
        System.out.println(data.getRoundState());
        if (data.isGameFinished()) {
            return new GameFinishedState(data, messeger);
        }
        else {
            data.prepareNewRound();
            return new RunningGameState(data, messeger);
        }
    }

}
