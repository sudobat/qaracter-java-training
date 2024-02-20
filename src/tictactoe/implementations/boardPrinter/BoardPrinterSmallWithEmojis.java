package tictactoe.implementations.boardPrinter;

import tictactoe.BoardPrinter;
import tictactoe.ReadOnlyBoard;

/**
 * Author: Javier Nakama
 */
public class BoardPrinterSmallWithEmojis extends BoardPrinterSmall implements BoardPrinter {
    public void print(ReadOnlyBoard board) {
        super.print(board);

        System.out.println("xD xD xD xD xD xDxD xD xDxD xD xDxD xD xDxD xD xDxD xD xDxD xD xD");
    }
    
}
