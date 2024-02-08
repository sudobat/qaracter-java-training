package tictactoe;

/**
 * Author: Brenda Lilian
 */
public class InputManager {
    public boolean validate(Board board, String input) {
        int position = parse(input);
        if (board.getState()[position] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Le va a entrar un String "1" - "9" y va a devolver un entero 1 - 9.
     */
    public int parse(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            return parsedInput;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}