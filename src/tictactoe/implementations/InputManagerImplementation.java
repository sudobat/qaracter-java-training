package tictactoe.implementations;

import tictactoe.InputManager;
import tictactoe.ReadOnlyBoard;

/**
 * Author: Brenda Lilian
 */
public class InputManagerImplementation implements InputManager {
    public boolean validate(ReadOnlyBoard board, String input) {
        int position = parse(input);
        return board.getState()[position - 1] == 0;
    }

    /**
     * Le va a entrar un String "1" - "9" y va a devolver un entero 1 - 9.
     */
    public int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}