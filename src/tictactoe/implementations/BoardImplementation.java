package tictactoe.implementations;

import tictactoe.Board;

import java.util.Arrays;

/**
 * Author: Elio Centurión
 */
public class BoardImplementation implements Board {
    private int[] state;

    public BoardImplementation() {
        this.state = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public BoardImplementation(int[] state) {
        this.state = Arrays.copyOf(state, state.length);
    }

    @Override
    public boolean update(int currentPlayer, int input) {

        if (currentPlayer == 1 || currentPlayer == 2) {
            state[input - 1] = currentPlayer;
            return true;
        } else return false;
    }

    @Override
    public void reset() {
        state = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    @Override
    public int[] getState() {
        return Arrays.copyOf(state, state.length);
    }
}