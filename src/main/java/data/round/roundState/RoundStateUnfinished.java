package data.round.roundState;

import messenger.MessageKeys;
import data.players.Players;

public class RoundStateUnfinished extends RoundState {
    @Override
    public String toString() {
        return "";
    }

    @Override
    public MessageKeys getMessageKey() {
        return MessageKeys.gameUnfinished;
    }

    @Override
    public Object [] getMessageKeyArguments() {
        return new Object[]{};
    }

    @Override
    public void addPointsAccordingRoundFinishedState(Players players) {
    }
}
