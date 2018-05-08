package Data;

public enum RoundState {
    // TODO translate it
    XWon{
        @Override
        public String toString() {
            return String.format("Rundę wygrywa %s.", Symbol.X);
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            players.addPointsToX(3);
        }
    },
    OWon{
        @Override
        public String toString() {
            return String.format("Rundę wygrywa %s.", Symbol.O);
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            players.addPointsToO(3);
        }
    },
    Draw{
        @Override
        public String toString() {
            return "Runda zakończona remisem !";
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
            return "Gra niezakończona.";
        }

        @Override
        void addPointsAccordingRoundFinishedState(Players players) {
            return;
        }
    };

    abstract void addPointsAccordingRoundFinishedState(Players players);
}
