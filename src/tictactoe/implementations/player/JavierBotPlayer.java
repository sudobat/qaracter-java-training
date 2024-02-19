package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

public class JavierBotPlayer implements Player {
    int myTurn;

    public JavierBotPlayer(int myTurn) {
        if (myTurn != 1 && myTurn != 2) {
            this.myTurn = 1;
        }

        this.myTurn = myTurn;
    }

    @Override
    public String makeMove(ReadOnlyBoard board) {

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
