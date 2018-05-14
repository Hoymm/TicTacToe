package data.round.roundState;

import data.messenger.MessageKeys;
import data.players.Players;

public interface RoundState {
    void addPointsAccordingRoundFinishedState(Players players);
    MessageKeys getMessageKey();
    Object [] getMessageKeyArguments();
}
