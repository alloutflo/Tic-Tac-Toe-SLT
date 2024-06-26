package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private final Board board;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();
        currentPlayer = new Player('X');
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard(currentPlayer);

            int row, col;
            while (true) {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();

                if (!board.placeMarker(row, col, currentPlayer.getSymbol())) {
                    System.out.println("Invalid move! Try again.");
                } else {
                    break;
                }
            }

            if (board.isWinner(currentPlayer.getSymbol())) {
                board.printBoard(currentPlayer);
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                if (!playAgain(scanner)) break;
            } else if (board.isBoardFull()) {
                board.printBoard(currentPlayer);
                System.out.println("It's a draw!");
                if (!playAgain(scanner)) break;
            } else {
                currentPlayer = Player.switchPlayer(currentPlayer);
            }
        }

        scanner.close();
    }

    private boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        if (response.equals("yes")) {
            board.initializeBoard();  // Reset the board for a new game
            currentPlayer = new Player('X');  // Reset the current player to 'X'
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }



}
