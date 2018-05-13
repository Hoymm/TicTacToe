package data;

import data.players.Player;

public enum Symbol {
    X{
        @Override
        public String toString() {
            return Colors.RED + super.toString() + Colors.DEFAULT;
        }

        @Override
        public Player whoShouldPlay(Player playerO, Player playerX) {
            return playerX;
        }


        @Override
        public Symbol getOppositeSymbol() {
            return O;
        }

    }, O{
        @Override
        public String toString() {
            return Colors.BLUE + super.toString() + Colors.DEFAULT;
        }

        @Override
        public Player whoShouldPlay(Player playerO, Player playerX) {
            return playerO;
        }

        @Override
        public Symbol getOppositeSymbol() {
            return X;
        }
    };

    abstract public Player whoShouldPlay(Player playerO, Player playerX);
    abstract public Symbol getOppositeSymbol();

    public Colors getColor(Player player) {
        if (player.getSymbol() == this)
            return Colors.ACTIVE;
        else
            return Colors.INACTIVE;
    }

    @SuppressWarnings("SameReturnValue")
    public Colors getDefaultColor() {
        return Colors.DEFAULT;
    }
}
