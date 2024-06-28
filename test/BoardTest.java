import TicTacToe.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Test

public class BoardTest {

    @Test
    public void testInitializeBoard() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCell(i, j));
            }
        }
    }

    @Test
    public void testPlaceMarkerPositive() {
        Board board = new Board();
        assertTrue(board.placeMarker(0, 0, 'X'));
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testPlaceMarkerNegative() {
        Board board = new Board();
        assertTrue(board.placeMarker(0, 0, 'X'));
        assertFalse(board.placeMarker(0, 0, 'O')); // cell already occupied
        assertFalse(board.placeMarker(3, 3, 'O')); // out of bounds
    }

    @Test
    public void testIsBoardFullPositive() {
        Board board = new Board();
        fillBoard(board);
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testIsBoardFullNegative() {
        Board board = new Board();
        assertFalse(board.isBoardFull());
    }

    private void fillBoard(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.placeMarker(i, j, 'X');
            }
        }
    }

    @Test
    public void testIsWinnerPositive() {
        Board board = new Board();
        board.placeMarker(0, 0, 'X');
        board.placeMarker(0, 1, 'X');
        board.placeMarker(0, 2, 'X');
        assertTrue(board.isWinner('X'));
    }

    @Test
    public void testIsWinnerNegative() {
        Board board = new Board();
        board.placeMarker(0, 0, 'X');
        board.placeMarker(0, 1, 'X');
        board.placeMarker(1, 2, 'X');
        assertFalse(board.isWinner('X'));
    }
}
