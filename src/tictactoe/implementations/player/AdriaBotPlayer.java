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

        for (int square: state) {
            if (square == 0) {
                return String.valueOf(square + 1);
            }
        }

        return "";
    }
}
