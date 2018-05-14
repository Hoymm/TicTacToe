package data.round.roundState;
import messenger.MessageKeys;
import data.players.Players;

public abstract class RoundState {
    public abstract void addPointsAccordingRoundFinishedState(Players players);
    public abstract MessageKeys getMessageKey();
    public abstract Object [] getMessageKeyArguments();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.getClass().getName().equals(o.getClass().getName());
    }

}
