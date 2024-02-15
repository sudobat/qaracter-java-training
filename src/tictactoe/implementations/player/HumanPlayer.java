package tictactoe.implementations.player;

import tictactoe.Player;
import tictactoe.ReadOnlyBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player {

    private final BufferedReader reader;

    public HumanPlayer() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String makeMove(ReadOnlyBoard board) {
        try {
            return reader.readLine();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}
