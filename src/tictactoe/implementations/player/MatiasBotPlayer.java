package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class MatiasBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        int[] state = board.getState();

        for (int position = 0; position < 9; position++) {
            if (state[position] == 0) {
                return String.valueOf(position + 1);
            }
        }

        return "";
    }
}
