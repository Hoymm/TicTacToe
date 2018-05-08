package Data;

public enum RoundState {
    XWon{
        @Override
        public String toString() {
            return "Rundę wygrywa X.";
        }
    },
    OWon{
        @Override
        public String toString() {
            return "Rundę wygrywa O.";
        }
    },
    Draw{
        @Override
        public String toString() {
            return "Runda zakończona remisem !";
        }
    },
    Unfinished {
        @Override
        public String toString() {
            return "Gra niezakończona.";
        }
    }

}
