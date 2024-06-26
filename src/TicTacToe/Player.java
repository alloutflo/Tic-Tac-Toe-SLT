package TicTacToe;

public class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Player switchPlayer(Player currentPlayer) {
        return currentPlayer.getSymbol() == 'X' ? new Player('O') : new Player('X');
    }
}
