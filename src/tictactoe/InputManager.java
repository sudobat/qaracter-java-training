package tictactoe;

/**
 * Author: Brenda Lilian
 */
public class InputManager {
    public boolean validate(Board board, String input) {
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
            ex.printStackTrace();
        }
        return 0;
    }
}