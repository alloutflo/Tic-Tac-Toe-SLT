package TicTacToe;

// a comment here
public class Board {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = ' ';
    private final char[][] board;

    public Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard(Player currentPlayer) {
        System.out.println("Current Player: " + currentPlayer.getSymbol());
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public boolean placeMarker(int row, int col, char marker) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
            return false;
        }
        board[row][col] = marker;
        return true;
    }
}
