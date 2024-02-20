package tictactoe.implementations.player;

import tictactoe.*;
import tictactoe.implementations.ArbiterImplementation;
import tictactoe.implementations.BoardImplementation;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdriaBotV2Player implements Player {

    private final Arbiter arbiter;
    private final BoardPrinter boardPrinter;

    public AdriaBotV2Player() {
        arbiter = new ArbiterImplementation();
        boardPrinter = new BoardPrinterLarge();
    }

    @Override
    public String makeMove(ReadOnlyBoard board, int myTurn) {

        boardPrinter.print(board);

        int[] state = board.getState();

        Board virtualBoard = new BoardImplementation(state);

        int bestMove = -1;
        int bestMoveValue = -1000;

        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        List<Integer> availableMoves = getAvailableMoves(state);

        for (int availableMove : availableMoves) {
            Board newVirtualBoard = new BoardImplementation(virtualBoard.getState());
            newVirtualBoard.update(myTurn, availableMove + 1);

            int moveValue = negaMax(newVirtualBoard, newTurn);

            System.out.println("Move = " + (availableMove + 1) + " evaluation = " + moveValue);

            if (moveValue > bestMoveValue) {
                bestMove = availableMove;
                bestMoveValue = moveValue;
            }
        }

        System.out.println();
        System.out.println("Best move = " + (bestMove + 1) + " evaluation = " + bestMoveValue);

        return String.valueOf(bestMove + 1);
    }

    private int negaMax(ReadOnlyBoard virtualBoard, int myTurn) {

        int evaluation = arbiter.checkIfGameIsFinished(virtualBoard);

        if (evaluation != -1) {
            int multiplier = 1;
            if (myTurn == 2) {
                multiplier = -1;
            }
            
            if (evaluation == 1) {
                return multiplier * 1000;
            } else if (evaluation == 2) {
                return multiplier * -1000;
            } else {
                return 0;
            }
        }

        int value = -1000;
        int newTurn = 1;
        if (myTurn == 1) {
            newTurn = 2;
        }

        int[] state = virtualBoard.getState();
        List<Integer> availableMoves = getAvailableMoves(state);

        for (int availableMove : availableMoves) {
            Board newVirtualBoard = new BoardImplementation(state);
            newVirtualBoard.update(myTurn, availableMove + 1);

            value = Math.max(value, -1 * negaMax(newVirtualBoard, newTurn));
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
