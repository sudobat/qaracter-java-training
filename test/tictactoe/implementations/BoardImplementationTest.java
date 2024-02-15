package tictactoe.implementations;

import org.junit.jupiter.api.Test;
import tictactoe.Board;

import static org.junit.jupiter.api.Assertions.*;

class BoardImplementationTest {
    private Board board;

    @Test
    void return_false_when_player_isnt_1_or_2() {
        board = new BoardImplementation();
        assertFalse(board.update(3, 1));
        assertEquals(0, board.getState()[0]);
    }

    @Test
    void return_true_when_player_is_1_or_2() {
        board = new BoardImplementation();
        assertTrue(board.update(1, 1));
        assertEquals(1, board.getState()[0]);
    }
}