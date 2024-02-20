package tictactoe.implementations.player;

import org.junit.jupiter.api.Test;
import tictactoe.Board;
import tictactoe.Player;
import tictactoe.implementations.BoardImplementation;

import static org.junit.jupiter.api.Assertions.*;

class AdriaBotV2PlayerTest {

    @Test
    void it_returns_the_right_move_analyzing_the_game_from_the_initial_position() {
        int[] initialState = new int[] {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0,
        };
        int initialTurn = 1;
        String expectedBestMove = "1";

        prepareTest(initialState, initialTurn, expectedBestMove);
    }

    @Test
    void it_returns_the_right_move_on_a_winning_position() {
        int[] initialState = new int[] {
                1, 1, 0,
                2, 2, 0,
                0, 0, 0,
        };
        int initialTurn = 1;
        String expectedBestMove = "3";

        prepareTest(initialState, initialTurn, expectedBestMove);
    }

    @Test
    void it_avoids_losing_on_a_drawn_position() {
        int[] initialState = new int[] {
                1, 0, 0,
                0, 2, 0,
                1, 0, 0,
        };
        int initialTurn = 2;
        String expectedBestMove = "4";

        prepareTest(initialState, initialTurn, expectedBestMove);
    }

    private void prepareTest(int[] initialState, int initialTurn, String expectedBestMove) {
        Player player = new AdriaBotV2Player(true);
        Board board = new BoardImplementation(initialState);

        String bestMove = player.makeMove(board, initialTurn);

        assertEquals(expectedBestMove, bestMove);
    }

}