package tictactoe.implementations;

import tictactoe.Board;

/**
 * Author: Elio Centurión
 */
public class BoardImplementation implements Board {
    private final int[] state;

    public BoardImplementation() {
        this.state = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public BoardImplementation(int[] state) {
        this.state = state;
    }

    public boolean update(int currentPlayer, int input) {

        if (currentPlayer == 1 || currentPlayer == 2) {
            state[input - 1] = currentPlayer;
            return true;
        } else return false;
    }

    public int[] getState() {
        return state;
    }
}