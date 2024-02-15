package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class AdriaBotPlayer implements Player {

    int myTurn;

    public AdriaBotPlayer(int myTurn) {
        if (myTurn != 1 && myTurn != 2) {
            this.myTurn = 1;
        }

        this.myTurn = myTurn;
    }

    @Override
    public String makeMove(ReadOnlyBoard board) {

        int[] state = board.getState();

        for (int position = 0; position < 9; position++) {
            if (state[position] == 0) {
                return String.valueOf(position + 1);
            }
        }

        return "";
    }
}
