package tictactoe;

public interface InputManager {
    boolean validate(ReadOnlyBoard board, String input);
    int parse(String input);
}
