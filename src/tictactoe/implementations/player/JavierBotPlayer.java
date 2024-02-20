package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class JavierBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        int[] state = board.getState();
        int winningPosition;
        winningPosition = findWinningMove(state, myTurn);
        if (winningPosition == -1) {
            for (int position = 0; position < 9; position++) {
                if (state[position] == 0) {
                    return String.valueOf(position + 1);
                }
            }
        } else
            return String.valueOf(winningPosition + 1);
        return "";
    }

    public int findWinningMove(int[] state, int myTurn) {
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                state[i] = myTurn;
                if (checkWin(myTurn, state)) {
                    state[i] = 0;
                    return i;
                }
                state[i] = 0;
            }
        }

        int opponent;
        if (myTurn == 1)
            opponent = 2;
        else
            opponent = 1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                state[i] = opponent;
                if (checkWin(opponent, state)) {
                    state[i] = 0;
                    return i;
                }
                state[i] = 0;
            }
        }
        return -1;
    }

    private int checkWin(int player, int[] state) {
        for (int i = 0; i < 3; i++) {
            if (state[i * 3] == state[i * 3 + 1] && state[i * 3 + 1] == state[i * 3 + 2] ) {
                if (state[i * 3]==player)
                    return 10;
                else
                    return -10;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (state[i] == player && state[i + 3] == player && state[i + 6] == player) {
                return true;
            }
        }

        if ((state[0] == player && state[4] == player && state[8] == player) ||
                (state[2] == player && state[4] == player && state[6] == player)) {
            return true;
        }

        return false;
    }
}
