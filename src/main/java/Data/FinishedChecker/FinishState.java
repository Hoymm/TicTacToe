package Data.FinishedChecker;

public enum FinishState {
    XWon{
        @Override
        public String toString() {
            return "Wygrywa X";
        }
    },
    OWon{
        @Override
        public String toString() {
            return "Wygrywa O";
        }
    },
    Draw{
        @Override
        public String toString() {
            return "Remis O";
        }
    },
    NotFinished{
        @Override
        public String toString() {
            return "Gra niezakończona";
        }
    }

}
