import tictactoe.*;
import tictactoe.implementations.ArbiterImplementation;
import tictactoe.implementations.BoardImplementation;
import tictactoe.implementations.InputManagerImplementation;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;
import tictactoe.implementations.player.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TournamentFactory tournamentFactory = new TournamentFactory();
        Tournament tournament = tournamentFactory.createTournament();
        tournament.play();
    }
}