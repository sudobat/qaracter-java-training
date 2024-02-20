package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class ElioBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        int[] state = board.getState();
        //Primero agarra el centro
        if (state[4] == 0) {
            return "5";
        }
        //Que agarre todas las esquinas
        if (state[0] == 0) {
            return "1";
        }

        if (state[2] == 0) {
            return "3";
        }
        if (state[6] == 0) {
            return "7";
        }
        if (state[8] == 0) {
            return "9";
        }
        //Que juegue lo que puede
        if (state[1] == 0) {
            return "2";
        }
        if (state[3] == 0) {
            return "4";
        }
        if (state[5] == 0) {
            return "6";
        }
        if (state[7] == 0) {
            return "8";
        }

        return "";
    }
}
