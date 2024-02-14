package tictactoe.implementations;

import tictactoe.Board;

/**
 * Author: Elio Centurión
 */
public class BoardImplementation implements Board {
    private final int[] state = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void update(int currentPlayer, int input) {
        state[input - 1] = currentPlayer;
    }

    public int[] getState() {
        return state;
    }
}