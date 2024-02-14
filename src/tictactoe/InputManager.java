package tictactoe;

public interface InputManager {
    boolean validate(Board board, String input);
    int parse(String input);
}
