package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class MatiasBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {
        int[] state = board.getState();

        // Check if it's the first move, choose the center for better chances
        if (myTurn == 1 && state[4] == 0) {
            return "5";
        }

        // Check for opponent's fork and block it
        String blockForkMove = blockOpponentFork(board, myTurn);
        if (!blockForkMove.isEmpty()) {
            return blockForkMove;
        }

        // Play in the opposite corner if the center is taken
        if (myTurn == 1 && state[4] == 1 && state[0] == 0) {
            return "1";
        }

        // Play in a corner if available
        for (int position : new int[]{0, 2, 6, 8}) {
            if (state[position] == 0) {
                return String.valueOf(position + 1);
            }
        }

        // Play in a side if no better moves are available
        for (int position : new int[]{1, 3, 5, 7}) {
            if (state[position] == 0) {
                return String.valueOf(position + 1);
            }
        }

        return "";
    }

    // Block opponent's fork if possible
    private String blockOpponentFork(ReadOnlyBoard board, int player) {
        int opponent = 3 - player; // Assuming players are denoted by 1 and 2

        for (int position = 0; position < 9; position++) {
            if (board.getState()[position] == 0) {
                int[] newState = board.getState().clone();
                newState[position] = opponent;

                // Check if the opponent's move creates a fork (simplified)
                if (isFork(newState, opponent)) {
                    return String.valueOf(position + 1);
                }
            }
        }

        return "";
    }

    // Check if the given move creates a fork for the player
    private boolean isFork(int[] state, int player) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (state[i] == player) {
                int[] newState = state.clone();
                newState[i] = 0; // Assume the player's move is undone
                if (hasTwoPotentialWins(newState, player)) {
                    count++;
                }
            }
        }
        return count >= 2;
    }

    // Check if the player has two potential winning lines in the given state
    private boolean hasTwoPotentialWins(int[] state, int player) {
        int[][] lines = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        int count = 0;
        for (int[] line : lines) {
            int symbolsInLine = 0;
            for (int position : line) {
                if (state[position] == player) {
                    symbolsInLine++;
                }
            }
            if (symbolsInLine == 2) {
                count++;
            }
        }

        return count >= 2;
    }
}
