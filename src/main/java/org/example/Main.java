package org.example;
import java.util.Scanner;

public class Main {

    public static class TicTacToe {
        private static final int BOARD_SIZE = 3;
        private static final char EMPTY = ' ';
        private final char[][] board;
        private char currentPlayer;

        public TicTacToe() {
            board = new char[BOARD_SIZE][BOARD_SIZE];
            currentPlayer = 'X';
            initializeBoard();
        }

        private void initializeBoard() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = EMPTY;
                }
            }
        }

        private void printBoard() {
            System.out.println("Current Player: " + currentPlayer);
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

        private boolean isBoardFull() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isWinner(char player) {
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

        private void switchPlayer() {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        public void playGame() {
            Scanner scanner = new Scanner(System.in);
            int row, col;

            while (true) {
                printBoard();

                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();

                if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                board[row][col] = currentPlayer;

                if (isWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                switchPlayer();
            }

            scanner.close();
        }

        public static void main(String[] args) {
            TicTacToe game = new TicTacToe();
            game.playGame();
        }
    }

}