import TicTacToe.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testGetSymbol() {
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        assertEquals('X', playerX.getSymbol());
        assertEquals('O', playerO.getSymbol());
    }

    @Test
    public void testSwitchPlayer() {
        Player playerX = new Player('X');
        Player playerO = Player.switchPlayer(playerX);
        assertEquals('O', playerO.getSymbol());

        Player playerXAgain = Player.switchPlayer(playerO);
        assertEquals('X', playerXAgain.getSymbol());
    }
}
