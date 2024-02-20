package tictactoe.implementations;

import tictactoe.InputManager;
import tictactoe.ReadOnlyBoard;

/**
 * Author: Brenda Lilian
 */
public class InputManagerImplementation implements InputManager {
    public boolean validate(ReadOnlyBoard board, String input) {
        int position = parse(input);
        if (position == 0) {
            return false;
        }

        return board.getState()[position - 1] == 0;
    }

    /**
     * Le va a entrar un String "1" - "9" y va a devolver un entero 1 - 9.
     */
    public int parse(String input) {
        try {
            int output = Integer.parseInt(input);

            if (output < 1 || output > 9) {
                return 0;
            }

            return output;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}