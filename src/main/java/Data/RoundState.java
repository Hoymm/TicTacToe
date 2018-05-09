package Data;

public enum RoundState {
    // TODO translate it
    XWon{
        @Override
        public MessageKeys getMessageKey() {
            return MessageKeys.theRoundWins;
        }

        @Override
        public Object [] getMessageKeyArguments() {
            return new Object[]{Symbol.X};
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            players.addPointsToX(3);
        }
    },
    OWon{
        @Override
        public MessageKeys getMessageKey() {
            return MessageKeys.theRoundWins;
        }

        @Override
        public Object [] getMessageKeyArguments() {
            return new Object[]{Symbol.O};
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            players.addPointsToO(3);
        }
    },
    Draw{
        @Override
        public MessageKeys getMessageKey() {
            return MessageKeys.roundIsFinishedWithDraw;
        }

        @Override
        public Object [] getMessageKeyArguments() {
            return new Object[]{};
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            players.addPointsToX(1);
            players.addPointsToO(1);
        }
    },
    Unfinished {
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
        void addPointsAccordingRoundFinishedState(Players players) {
            return;
        }
    };

    abstract void addPointsAccordingRoundFinishedState(Players players);

    abstract public MessageKeys getMessageKey();
    abstract public Object [] getMessageKeyArguments();
}
