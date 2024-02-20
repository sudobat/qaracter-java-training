package tictactoe.implementations.player;

import tictactoe.Arbiter;
import tictactoe.Board;
import tictactoe.Player;
import tictactoe.ReadOnlyBoard;
import tictactoe.implementations.ArbiterImplementation;
import tictactoe.implementations.BoardImplementation;

import java.util.ArrayList;
import java.util.List;

public class AdriaBotV2Player implements Player {

    private final Arbiter arbiter;

    public AdriaBotV2Player() {
        arbiter = new ArbiterImplementation();
    }

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        int[] state = board.getState();

        Board virtualBoard = new BoardImplementation(state);

        int bestMove = -2;
        int bestMoveValue = -1000;

        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        for (int availableMove : getAvailableMoves(state)) {
            int moveValue = negaMax(virtualBoard, availableMove, newTurn);

            if (moveValue > bestMoveValue) {
                bestMove = availableMove;
            }
        }

        return String.valueOf(bestMove + 1);
    }

    private int negaMax(ReadOnlyBoard virtualBoard, int move, int myTurn) {

        Board newVirtualBoard = new BoardImplementation(virtualBoard.getState());
        newVirtualBoard.update(myTurn, move);

        int evaluation = arbiter.checkIfGameIsFinished(newVirtualBoard);

        if (evaluation != -1) {
            if (evaluation == 1) {
                return 1000;
            } else if (evaluation == 2) {
                return -1000;
            } else {
                return 0;
            }
        }

        int value = -1000;
        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        for (int availableMove : getAvailableMoves(newVirtualBoard.getState())) {
            value = Math.max(value, -1 * negaMax(newVirtualBoard, availableMove, newTurn));
        }

        return value;
    }

    private List<Integer> getAvailableMoves(int[] state) {
        List<Integer> availableMoves = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                availableMoves.add(i);
            }
        }

        return availableMoves;
    }
}
