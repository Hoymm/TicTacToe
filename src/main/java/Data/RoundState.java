package Data;

public enum RoundState {
    XWon{
        @Override
        public String toString() {
            return "Wygrywa X.";
        }
    },
    OWon{
        @Override
        public String toString() {
            return "Wygrywa O.";
        }
    },
    Draw{
        @Override
        public String toString() {
            return "Remis !";
        }
    },
    NotFinished{
        @Override
        public String toString() {
            return "Gra niezakończona.";
        }
    }

}
