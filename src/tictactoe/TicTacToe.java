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

    private final boolean debug;

    public TicTacToe(Board board,
                     BoardPrinter printer,
                     InputManager inputManager,
                     Arbiter arbiter,
                     Player player1,
                     Player player2,
                     boolean debug
    ) {
        this.board = board;
        this.printer = printer;
        this.inputManager = inputManager;
        this.arbiter = arbiter;
        this.player1 = player1;
        this.player2 = player2;

        currentPlayer = 1;

        this.debug = debug;
    }

    public TicTacToe(
            Board board,
            BoardPrinter printer,
            InputManager inputManager,
            Arbiter arbiter,
            Player player1,
            Player player2
    ) {
        this(
            board,
            printer,
            inputManager,
            arbiter,
            player1,
            player2,
            true
        );
    }

    public int play() {
        if (debug) {
            printer.print(board);
            System.out.println("Le toca tirar al jugador " + currentPlayer);
        }

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

            if (debug) {
                printer.print(board);
            }

            result = arbiter.checkIfGameIsFinished(board);

            if (result == 1) {
                if (debug) {
                    System.out.println("Ha ganado el jugador 1!");
                }
                printer.print(board);
                return result;
            } else if (result == 2) {
                if (debug) {
                    System.out.println("Ha ganado el jugador 2!");
                }
                printer.print(board);
                return result;
            } else if (result == 0) {
                if (debug) {
                    System.out.println("Empate!");
                }
                printer.print(board);
                return result;
            }

            changeCurrentPlayer();

            if (debug) {
                System.out.println("Le toca tirar al jugador " + currentPlayer);
            }
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
