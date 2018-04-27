package Data;

public enum Symbol {
    X{
        @Override
        public String toString() {
            return Colors.RED + super.toString() + Colors.DEFAULT;
        }

    }, O{
        @Override
        public String toString() {
            return Colors.BLUE + super.toString() + Colors.DEFAULT;
        }
    };

    public Player whoShouldPlay(Player playerO, Player playerX) {
        switch (this){
            case X:
                return playerX;
            case O:
                return playerO;
        }
        return null;
    }

    public Colors getColor(Player player) {
        if (player.getSymbol() == this)
            return Colors.ACTIVE;
        else
            return Colors.INACTIVE;
    }

    public Colors getDefaultColor() {
        return Colors.DEFAULT;
    }

    public Symbol getOppositeSymbol() {
        if (this == Symbol.X)
            return Symbol.O;
        else
            return Symbol.X;
    }
}
