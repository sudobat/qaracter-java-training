import tictactoe.*;
import tictactoe.implementations.*;

public class Main {

    public static void main(String[] args) {

        Board board = new BoardImplementation();
        BoardPrinter smallPrinter = new BoardPrinterSmall();
        BoardPrinter largePrinter = new BoardPrinterLarge();
        InputManager inputManager = new InputManagerImplementation();
        Arbiter arbiter = new ArbiterImplementation();

        TicTacToe ticTacToe = new TicTacToe(
                board,
                largePrinter,
                inputManager,
                arbiter
        );

        ticTacToe.play();
    }
}