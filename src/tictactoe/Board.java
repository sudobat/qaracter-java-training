package tictactoe;

public interface Board extends ReadOnlyBoard {
    boolean update(int currentPlayer, int input);
}
