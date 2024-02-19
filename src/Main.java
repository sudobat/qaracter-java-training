import tictactoe.*;
import tictactoe.implementations.ArbiterImplementation;
import tictactoe.implementations.BoardImplementation;
import tictactoe.implementations.InputManagerImplementation;
import tictactoe.implementations.boardPrinter.BoardPrinterLarge;
import tictactoe.implementations.player.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Player, Integer> playersWithScores = new HashMap<>() {{
            put(new AdriaBotPlayer(), 0);
            put(new ElioBotPlayer(), 0);
            put(new JavierBotPlayer(), 0);
            put(new BrendaBotPlayer(), 0);
            put(new MatiasBotPlayer(), 0);
        }};

        playTournament(playersWithScores);

        printTournamentResult(playersWithScores);
    }

    private static void playTournament(Map<Player, Integer> playersWithScores) {
        for (Map.Entry<Player, Integer> player1 : playersWithScores.entrySet()) {
            for (Map.Entry<Player, Integer> player2 : playersWithScores.entrySet()) {
                if (player1.getKey() == player2.getKey()) {
                    continue;
                }

                int result = playMatch(player1.getKey(), player2.getKey());

                if (result == 1) {
                    player1.setValue(player1.getValue() + 1);
                } else if (result == 2) {
                    player2.setValue(player2.getValue() + 1);
                }
            }
        }
    }

    private static void printTournamentResult(Map<Player, Integer> playersWithScores) {
        System.out.println("");
        System.out.println("+-------------------+");
        System.out.println("| TOURNAMENT RESULT |");
        System.out.println("+-------------------+");
        System.out.println("");

        Comparator<Map.Entry<Player, Integer>> scoreComparator = (p1, p2) -> {
            Integer s1 = p1.getValue();
            Integer s2 = p2.getValue();
            return s2.compareTo(s1);
        };

        List<Map.Entry<Player, Integer>> listOfEntries
                = new ArrayList<>(playersWithScores.entrySet());

        listOfEntries.sort(scoreComparator);

        for (Map.Entry<Player, Integer> player : listOfEntries) {
            System.out.println(player.getKey().getClass().getSimpleName() + " Score: " + player.getValue());
        }
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