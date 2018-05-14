package data.round.roundState;

import data.Symbol;
import data.messenger.MessageKeys;
import data.players.Players;

public class RoundStateXWon implements RoundState {
    @Override
    public MessageKeys getMessageKey() {
        return MessageKeys.theRoundWins;
    }

    @Override
    public Object [] getMessageKeyArguments() {
        return new Object[]{Symbol.X};
    }

    @Override
    public void addPointsAccordingRoundFinishedState(Players players) {
        players.addPointsToX(3);
    }
}
