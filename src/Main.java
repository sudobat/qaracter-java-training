import tictactoe.*;
import tictactoe.implementations.*;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;
import tictactoe.implementations.player.AdriaBotPlayer;
import tictactoe.implementations.player.BrendaBotPlayer;
import tictactoe.implementations.player.ElioBotPlayer;
import tictactoe.implementations.player.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        int adriaBotScore = 0;
        int elioBotScore = 0;
        int brendaBotScore = 0;
        int javierBotScore = 0;
        int matiasBotScore = 0;

        int result = playMatch(
                new AdriaBotPlayer(1),
                new ElioBotPlayer(2)
        );

        if (result == 1) {
            adriaBotScore++;
        } else if (result == 2) {
            elioBotScore++;
        }

        result = playMatch(
                new ElioBotPlayer(1),
                new AdriaBotPlayer(2)
        );

        if (result == 1) {
            elioBotScore++;
        } else if (result == 2) {
            adriaBotScore++;
        }

        System.out.println("+-------------------+");
        System.out.println("| TOURNAMENT RESULT |");
        System.out.println("+-------------------+");
        System.out.println("Adria Bot Score: " + adriaBotScore);
        System.out.println("Elio Bot Score: " + elioBotScore);
    }

    private static int playMatch(Player player1, Player player2) {

        Board board = new BoardImplementation();
        BoardPrinter printer = new BoardPrinterLarge();
        InputManager inputManager = new InputManagerImplementation();
        Arbiter arbiter = new ArbiterImplementation();

        TicTacToe ticTacToe = new TicTacToe(
                board,
                printer,
                inputManager,
                arbiter,
                player1,
                player2
        );

        return ticTacToe.play();
    }
}