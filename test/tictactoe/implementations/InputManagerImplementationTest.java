package tictactoe.implementations;

import org.junit.jupiter.api.Test;
import tictactoe.InputManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputManagerImplementationTest {

    private final InputManager inputManager;

    public InputManagerImplementationTest() {
        inputManager = new InputManagerImplementation();
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
    void parse_returns_0_when_receivinh_an_non_alfa_numeric_caracter() {
        assertEquals(0, inputManager.parse(","));
    }
}