package Data;

public enum RoundState {
    XWon{
        @Override
        public String toString() {
            return String.format("Rundę wygrywa %s.", Symbol.X);
        }
    },
    OWon{
        @Override
        public String toString() {
            return String.format("Rundę wygrywa %s.", Symbol.O);
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
