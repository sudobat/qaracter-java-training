package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrendaBotPlayer implements Player {

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {
        int[] state = board.getState();

        // Para ganar
        int winMove = findWinningMove(state, myTurn);
        if (winMove != -1) {
            return String.valueOf(winMove);
        }

        // Bloquear
        int blockMove = findWinningMove(state, myTurn == 1 ? 2 : 1);
        if (blockMove != -1) {
            return String.valueOf(blockMove);
        }

        // Esquina-Centro-Lado
        List<Integer> moves = new ArrayList<>();
        for (int position = 0; position < 9; position++) {
            if (state[position] == 0) {
                moves.add(position + 1);
            }
        }

        // aleatorio
        if (!moves.isEmpty()) {
            Random random = new Random();
            return String.valueOf(moves.get(random.nextInt(moves.size())));
        }

        return "";
    }
    private int findWinningMove(int[] state, int playerTurn) {
        for (int i = 0; i < 9; i += 3) {
            if (state[i] == playerTurn && state[i + 1] == playerTurn && state[i + 2] == 0) return i + 3;
            if (state[i] == playerTurn && state[i + 2] == playerTurn && state[i + 1] == 0) return i + 2;
            if (state[i + 1] == playerTurn && state[i + 2] == playerTurn && state[i] == 0) return i + 1;
        }

        for (int i = 0; i < 3; i++) {
            if (state[i] == playerTurn && state[i + 3] == playerTurn && state[i + 6] == 0) return i + 7;
            if (state[i] == playerTurn && state[i + 6] == playerTurn && state[i + 3] == 0) return i + 4;
            if (state[i + 3] == playerTurn && state[i + 6] == playerTurn && state[i] == 0) return i + 1;
        }

        if (state[0] == playerTurn && state[4] == playerTurn && state[8] == 0) return 9;
        if (state[0] == playerTurn && state[8] == playerTurn && state[4] == 0) return 5;
        if (state[4] == playerTurn && state[8] == playerTurn && state[0] == 0) return 1;

        if (state[2] == playerTurn && state[4] == playerTurn && state[6] == 0) return 7;
        if (state[2] == playerTurn && state[6] == playerTurn && state[4] == 0) return 5;
        if (state[4] == playerTurn && state[6] == playerTurn && state[2] == 0) return 3;

        return -1;
    }

}


