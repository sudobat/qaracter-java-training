package tictactoe;

import java.util.Map;

public class TicTacToe {

    private final Board board;
    private final BoardPrinter printer;
    private final InputManager inputManager;
    private final Arbiter arbiter;
    private final Player player1;
    private final Player player2;

    private int currentPlayer;

    public TicTacToe(
            Board board,
            BoardPrinter printer,
            InputManager inputManager,
            Arbiter arbiter,
            Player player1,
            Player player2
    ) {
        this.board = board;
        this.printer = printer;
        this.inputManager = inputManager;
        this.arbiter = arbiter;
        this.player1 = player1;
        this.player2 = player2;

        currentPlayer = 1;
    }

    public int play() {
        printer.print(board);
        System.out.println("Le toca tirar al jugador " + currentPlayer);

        String input;

        int result = arbiter.checkIfGameIsFinished(board);

        while (result == -1) {

            if (currentPlayer == 1) {
                input = player1.makeMove(board, currentPlayer);
            } else {
                input = player2.makeMove(board, currentPlayer);
            }

            boolean isInputValid = inputManager.validate(board, input);

            if (!isInputValid) {
                System.out.println("Jugada inválida, vuelve a tirar un número válido del 1 al 9.");
                continue;
            }

            int playerInput = inputManager.parse(input);

            board.update(currentPlayer, playerInput);

            printer.print(board);

            result = arbiter.checkIfGameIsFinished(board);

            if (result == 1) {
                System.out.println("Ha ganado el jugador 1!");
                return result;
            } else if (result == 2) {
                System.out.println("Ha ganado el jugador 2!");
                return result;
            } else if (result == 0) {
                System.out.println("Empate!");
                return result;
            }

            changeCurrentPlayer();

            System.out.println("Le toca tirar al jugador " + currentPlayer);
        }

        return 0;
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }
}
