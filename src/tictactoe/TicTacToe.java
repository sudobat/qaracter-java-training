package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    public void play() {
        try {
            int currentPlayer = 1;

            Board board = new Board();

            BoardPrinter printer = new BoardPrinter();
            printer.print(board);

            InputValidator inputValidator = new InputValidator();

            Arbiter arbiter = new Arbiter();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;

            System.out.println("Le toca tirar al jugador " + currentPlayer);

            while ((input = reader.readLine()) != null) {
                boolean isInputValid = inputValidator.validate(board, input);

                if (! isInputValid) {
                    System.out.println("Jugada inválida, vuelve a tirar un número válido del 1 al 9.");
                    continue;
                }

                board.update(currentPlayer, input);

                printer.print(board);

                /**
                 * Si result vale 1, ha ganado el jugador 1
                 * Si result vale 2, ha ganado el jugador 2
                 * Si result vale 0, ha resultado en empate
                 * Si result vale -1, el juego sigue.
                 */
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

                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }

                System.out.println("Le toca tirar al jugador " + currentPlayer);
            }
        } catch (IOException exception) {
          System.out.println(exception.getMessage());
        }
    }
}
