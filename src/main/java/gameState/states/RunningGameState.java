package gameState.states;

import data.*;
import messenger.Messenger;
import data.round.roundState.RoundStateUnfinished;
import gameState.Game;

public class RunningGameState extends Game {

    RunningGameState(Data data, Messenger messenger) {
        super(data, messenger);
        data.setCurrentPlayerToOneWhoStartsRound();
        data.setWhoStartedLastRoundToOpposite();
    }

    @Override
    public Game getNextState() {
        data.changeCurrentPlayerToOpposite();
        if (!data.getRoundState().equals(new RoundStateUnfinished())) {
            data.incrementRoundsPlayed();
            data.addPointsToPlayers();
            return new RoundFinishedState(data, messenger);
        }
        return this;
    }

    @Override
    public boolean tryFetchAndProcessValidInputFromUser() {
        userIO.loadFromUserFieldNumberOnBoardToPutSymbol();
        return userWantsToStayInGame() && data.tryToInsertNewCoordinates(Integer.valueOf(userIO.getLastInput()), messenger);
    }
}
