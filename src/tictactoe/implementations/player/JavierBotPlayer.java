package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

import java.util.Scanner;

public class JavierBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {
        int[] state = board.getState();
        int bestMove = scorePlay(myTurn, state);
        return String.valueOf((bestMove + 1));
    }


    // Tabla de valores:
// 10 gana player
// -10 pierde player
// 1 empate
// 0 continua el juego
    private int checkWin(int player, int[] state) {
        int opponent = (player == 1) ? 2 : 1;
        //Horizontales
        for (int i = 0; i < 3; i++) {
            if (state[i * 3] == state[i * 3 + 1] && state[i * 3 + 1] == state[i * 3 + 2]) {
                if (state[i * 3] == player)
                    return 10;
                else if (state[i * 3] == opponent)
                    return -10;
            }
        }
        //Verticales
        for (int i = 0; i < 3; i++) {
            if (state[i] == player && state[i + 3] == player && state[i + 6] == player) {
                if (state[i] == player)
                    return 10;
                else if (state[i] == opponent)
                    return -10;
            }
        }
        //Oblicuas
        if (state[0] == state[4] && state[4] == state[8]) {
            if (state[0] == player)
                return 10;
            else if (state[0] == opponent)
                return -10;
        }
        if (state[2] == state[4] && state[4] == state[6]) {
            if (state[2] == player)
                return 10;
            else if (state[2] == opponent)
                return -10;
        }
        //Empate
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0)
                break;
            if (i == 8)
                return 1;

        }
        //Continue
        return 0;
    }

    private int scorePlay(int myTurn, int[] state) {
        int opponent = (myTurn == 1) ? 2 : 1;
        int bestMove = -1;
        int bestScore = (myTurn == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int evaluation = checkWin(myTurn, state);

        if (evaluation != 0) {
            return evaluation;
        }

        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                state[i] = myTurn;
                int score = scorePlay(opponent, state);
                state[i] = 0;

                if (myTurn == 1) {
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = i;
                    }
                } else {
                    if (score < bestScore) {
                        bestScore = score;
                        bestMove = i;
                    }
                }
            }
        }
        if (myTurn == 1) {
            return bestMove;
        } else {
            return bestScore;
        }
    }
}
