package data;

import data.players.Player;

public enum Symbol {
    X{
        @Override
        public String toString() {
            return Colors.RED + super.toString() + Colors.INACTIVE;
        }

        @Override
        public Symbol getOppositeSymbol() {
            return O;
        }

    }, O{
        @Override
        public String toString() {
            return Colors.BLUE + super.toString() + Colors.INACTIVE;
        }

        @Override
        public Symbol getOppositeSymbol() {
            return X;
        }
    };

    public Player whoShouldPlay(Player player1, Player player2){
        if (this.equals(player1.getSymbol())) {
            return player1;
        }
        else{
            return player2;
        }
    }
    abstract public Symbol getOppositeSymbol();

    public Colors getColor(Player player) {
        if (player.getSymbol() == this)
            return Colors.ACTIVE;
        else
            return Colors.INACTIVE;
    }
}
