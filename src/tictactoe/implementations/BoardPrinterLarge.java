package tictactoe.implementations;

import tictactoe.Board;
import tictactoe.BoardPrinter;

/**
 * Author: Javier Nakama
 */
public class BoardPrinterLarge implements BoardPrinter {
    public void print(Board board) {
        int[] boardState = board.getState();
        char[] boardToChar = new char[9];
        for (int i = 0; i < 9; i++) {
            switch (boardState[i]) {
                case 0 -> boardToChar[i] = ' ';
                case 1 -> boardToChar[i] = 'O';
                case 2 -> boardToChar[i] = 'X';
            }
        }
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ " + boardToChar[0] + " │ " + boardToChar[1] + " │ " + boardToChar[2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + boardToChar[3] + " │ " + boardToChar[4] + " │ " + boardToChar[5] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + boardToChar[6] + " │ " + boardToChar[7] + " │ " + boardToChar[8] + " │");
        System.out.println("└───┴───┴───┘");
    }

}
