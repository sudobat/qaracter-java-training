package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class JavierBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        int[] state = board.getState();
        int movesCount = 0;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 1 || state[i] == 2){
                movesCount++;
            }
        }
        if(movesCount<2){

        }

        return "";
    }
}
