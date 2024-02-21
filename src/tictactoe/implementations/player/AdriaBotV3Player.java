package tictactoe.implementations.player;

import tictactoe.BoardPrinter;
import tictactoe.Player;
import tictactoe.ReadOnlyBoard;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;

import java.util.ArrayList;
import java.util.List;

public class AdriaBotV3Player implements Player {

    private final BoardPrinter boardPrinter;
    private int[] state;
    private int[] availableMoves;
    private final boolean debug;
    private int visitedNodes = 0;

    public AdriaBotV3Player(boolean debug) {
        boardPrinter = new BoardPrinterLarge();
        this.debug = debug;
    }

    public AdriaBotV3Player() {
        this(false);
    }

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        long startTime = System.nanoTime();
        visitedNodes = 1;

        if (debug) {
            boardPrinter.print(board);
        }

        state = board.getState();
        availableMoves = new int[9];

        int bestMove = -1;
        int bestMoveValue = -1;

        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        List<Integer> availableMoves = getAvailableMoves();

        for (int availableMove : availableMoves) {

            doMove(availableMove, myTurn);

            int moveValue = - 1 * negaMax(newTurn);

            undoMove(availableMove);

            if (debug) {
                System.out.println("Move = " + (availableMove + 1) + " evaluation = " + moveValue);
            }

            if (moveValue > bestMoveValue) {
                bestMove = availableMove;
                bestMoveValue = moveValue;
            }
        }

        if (debug) {
            System.out.println();
            System.out.println("Best move = " + (bestMove + 1)
                    + " evaluation = " + bestMoveValue);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;

            System.out.println("Time = " + duration + "ms"
                    + " nodes = " + visitedNodes);
        }

        return String.valueOf(bestMove + 1);
    }

    private int negaMax(int myTurn) {

        int evaluation = checkIfGameIsFinished();

        if (evaluation != -1) {
            int multiplier = 1;
            if (myTurn == 2) {
                multiplier = -1;
            }
            
            if (evaluation == 1) {
                return multiplier;
            } else if (evaluation == 2) {
                return multiplier * -1;
            } else {
                return 0;
            }
        }

        int value = -1;
        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        List<Integer> availableMoves = getAvailableMoves();

        for (int availableMove : availableMoves) {
            doMove(availableMove, myTurn);

            value = Math.max(value, -1 * negaMax(newTurn));

            undoMove(availableMove);
        }

        return value;
    }

    private int checkIfGameIsFinished() {
        int numberOfZeroes = 0;

        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                numberOfZeroes++;
            }

            if (numberOfZeroes == 5) {
                return -1; // Can't win with 5 or more empty squares
            }
        }

        // Horizontal
        if (state[0] != 0 && state[0] == state[1] && state[1] == state[2]) {
            return state[0];
        }
        if (state[3] != 0 && state[3] == state[4] && state[4] == state[5]) {
            return state[3];
        }
        if (state[6] != 0 && state[6] == state[7] && state[6] == state[8]) {
            return state[6];
        }

        // Vertical
        if (state[0] != 0 && state[0] == state[3] && state[0] == state[6]) {
            return state[0];
        }
        if (state[1] != 0 && state[1] == state[4] && state[1] == state[7]) {
            return state[1];
        }
        if (state[2] != 0 && state[2] == state[5] && state[2] == state[8]) {
            return state[2];
        }

        // Diagonal
        if (state[0] != 0 && state[0] == state[4] && state[0] == state[8]) {
            return state[0];
        }
        if (state[2] != 0 && state[2] == state[4] && state[2] == state[6]) {
            return state[2];
        }

        if (numberOfZeroes == 0) {
            return 0;
        }

        return -1;
    }

    private void doMove(int move, int myTurn) {
        state[move] = myTurn;
        visitedNodes++;
    }

    private void undoMove(int move) {
        state[move] = 0;
    }

    private List<Integer> getAvailableMoves() {
        List<Integer> availableMoves = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                availableMoves.add(i);
            }
        }

        return availableMoves;
    }
}
