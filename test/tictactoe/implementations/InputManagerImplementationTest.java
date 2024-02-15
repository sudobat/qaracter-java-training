package tictactoe.implementations;

import org.junit.jupiter.api.Test;
import tictactoe.Board;
import tictactoe.InputManager;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerImplementationTest {

    private final InputManager inputManager;
    private Board board;

    public InputManagerImplementationTest() {
        inputManager = new InputManagerImplementation();
        board = new BoardImplementation();

    }

    @Test
    void parse_returns_0_when_receiving_a_letter() {
        assertEquals(0, inputManager.parse("A"));
    }

    @Test
    void parse_returns_0_when_receiving_a_float_as_string() {
        assertEquals(0, inputManager.parse("1.5"));
    }

    @Test
    void parse_returns_0_when_receiving_an_integer_out_of_range() {
        assertEquals(0, inputManager.parse("20"));
    }

    @Test
    void parse_returns_0_when_receiving_an_non_alfa_numeric_character() {
        assertEquals(0, inputManager.parse(","));
    }

    @Test
    void validate_return_true_board_empty_and_input_1_9() {
        assertTrue(inputManager.validate(board, "1"));
    }

    @Test
    void validate_return_false_board_empty_and_input_out_of_range() {
        assertFalse(inputManager.validate(board, "12"));
    }

    @Test
    void validate_return_false_board_not_empty_and_input_occupied() {
        board = new BoardImplementation(new int[]{
                1, 2, 1,
                0, 0, 0,
                2, 1, 2
        });
        assertFalse(inputManager.validate(board, "1"));
    }
}