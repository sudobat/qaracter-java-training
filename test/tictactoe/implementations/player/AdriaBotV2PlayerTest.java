package tictactoe.implementations.player;

import org.junit.jupiter.api.Test;
import tictactoe.Player;
import tictactoe.implementations.BoardImplementation;

import static org.junit.jupiter.api.Assertions.*;

class AdriaBotV2PlayerTest {

    @Test
    void it_returns_the_right_move_analyzing_the_game_from_the_initial_position() {
        Player player = new AdriaBotV2Player();

        String bestMove = player.makeMove(new BoardImplementation(), 1);

        assertEquals("5", bestMove);
    }

}