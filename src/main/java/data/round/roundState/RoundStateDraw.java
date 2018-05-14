package data.round.roundState;

import data.messenger.MessageKeys;
import data.players.Players;

public class RoundStateDraw extends RoundState {
    @Override
    public MessageKeys getMessageKey() {
        return MessageKeys.roundIsFinishedWithDraw;
    }

    @Override
    public Object [] getMessageKeyArguments() {
        return new Object[]{};
    }

    @Override
    public void addPointsAccordingRoundFinishedState(Players players) {
        players.addPointsToX(1);
        players.addPointsToO(1);
    }
}
