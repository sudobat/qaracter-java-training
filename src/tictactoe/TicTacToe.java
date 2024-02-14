package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private final Board board;
    private final BoardPrinter printer;
    private final InputManager inputManager;
    private final Arbiter arbiter;
    private final BufferedReader reader;
    private int currentPlayer;

    public TicTacToe(
            Board board,
            BoardPrinter printer,
            InputManager inputManager,
            Arbiter arbiter
    ) {
        this.board = board;
        this.printer = printer;
        this.inputManager = inputManager;
        this.arbiter = arbiter;

        currentPlayer = 1;

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void play() {
        try {
            printer.print(board);
            System.out.println("Le toca tirar al jugador " + currentPlayer);

            String input;
            while ((input = reader.readLine()) != null) {
                boolean isInputValid = inputManager.validate(board, input);

                if (! isInputValid) {
                    System.out.println("Jugada inválida, vuelve a tirar un número válido del 1 al 9.");
                    continue;
                }

                int playerInput = inputManager.parse(input);

                board.update(currentPlayer, playerInput);

                printer.print(board);

                int result = arbiter.checkIfGameIsFinished(board);

                if (result == 1) {
                    System.out.println("Ha ganado el jugador 1!");
                    break;
                } else if (result == 2) {
                    System.out.println("Ha ganado el jugador 2!");
                    break;
                } else if (result == 0) {
                    System.out.println("Empate!");
                    break;
                }

                changeCurrentPlayer();

                System.out.println("Le toca tirar al jugador " + currentPlayer);
            }
        } catch (IOException exception) {
          System.out.println(exception.getMessage());
        }
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }
}
