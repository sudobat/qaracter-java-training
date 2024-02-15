import tictactoe.*;
import tictactoe.implementations.*;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;
import tictactoe.implementations.player.AdriaBotPlayer;
import tictactoe.implementations.player.BrendaBotPlayer;
import tictactoe.implementations.player.ElioBotPlayer;
import tictactoe.implementations.player.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        Board board = new BoardImplementation();
        BoardPrinter printer = new BoardPrinterLarge();
        InputManager inputManager = new InputManagerImplementation();
        Arbiter arbiter = new ArbiterImplementation();
        Player player1 = new HumanPlayer();
        Player player2 = new AdriaBotPlayer(2);

        TicTacToe ticTacToe = new TicTacToe(
                board,
                printer,
                inputManager,
                arbiter,
                player1,
                player2
        );

        ticTacToe.play();
    }
}