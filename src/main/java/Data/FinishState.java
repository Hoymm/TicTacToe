package Data;

public enum FinishState {
    XWon{
        @Override
        public String toString() {
            return "Wins " + Symbol.X;
        }
    },
    OWon{
        @Override
        public String toString() {
            return "Wins " + Symbol.O;
        }
    },
    Draw{
        @Override
        public String toString() {
            return "Draw !";
        }
    },
    NotFinished{
        @Override
        public String toString() {
            return "Game unfinished.";
        }
    }

}
