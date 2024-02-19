package tictactoe;

import tictactoe.implementations.ArbiterImplementation;
import tictactoe.implementations.BoardImplementation;
import tictactoe.implementations.InputManagerImplementation;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;
import tictactoe.implementations.player.*;

import java.util.ArrayList;
import java.util.List;

public class TournamentFactory {

    public Tournament createTournament() {
        Board board = new BoardImplementation();
        BoardPrinter printer = new BoardPrinterLarge();
        InputManager inputManager = new InputManagerImplementation();
        Arbiter arbiter = new ArbiterImplementation();

        List<Player> players = new ArrayList<>() {{
            add(new AdriaBotPlayer());
            add(new ElioBotPlayer());
            add(new JavierBotPlayer());
            add(new BrendaBotPlayer());
            add(new MatiasBotPlayer());
        }};

        return new Tournament(
                board,
                printer,
                inputManager,
                arbiter,
                players
        );
    }
}
