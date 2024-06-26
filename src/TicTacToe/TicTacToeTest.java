package TicTacToe;

import org.junit.Test;
import static org.junit.Assert.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TicTacToeTest {

    @Test
    public void testPlayGameWin() {
        String input = "0\n0\n0\n1\n1\n1\n2\n2\n"; // sequence of moves leading to a win for 'X'
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TicTacToe game = new TicTacToe();
        game.playGame();
        Board board = new Board();
        assertTrue(board.isWinner('X'));
    }

    @Test
    public void testPlayGameDraw() {
        String input = "0\n0\n0\n1\n0\n2\n1\n0\n1\n1\n2\n1\n1\n2\n2\n0\n2\n2\n2\n1\n"; // sequence of moves leading to a draw
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TicTacToe game = new TicTacToe();
        game.playGame();
        Board board = new Board();
        assertFalse(board.isWinner('X'));
        assertFalse(board.isWinner('O'));
        assertTrue(board.isBoardFull());
    }
}