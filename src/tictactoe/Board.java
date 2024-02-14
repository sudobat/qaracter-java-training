package tictactoe;

public interface Board extends ReadOnlyBoard {
    void update(int currentPlayer, int input);
}
