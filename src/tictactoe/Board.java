package tictactoe;

public interface Board {
    void update(int currentPlayer, int input);
    int[] getState();
}
