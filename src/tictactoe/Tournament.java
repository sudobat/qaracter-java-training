package tictactoe;

import java.util.*;

public class Tournament {

    private final Board board;
    private final BoardPrinter printer;
    private final InputManager inputManager;
    private final Arbiter arbiter;
    private final List<Player> players;

    public Tournament(
            Board board,
            BoardPrinter printer,
            InputManager inputManager,
            Arbiter arbiter,
            List<Player> players
    ) {
        this.board = board;
        this.printer = printer;
        this.inputManager = inputManager;
        this.arbiter = arbiter;
        this.players = players;
    }

    private Map<Player, Integer> createMap(List<Player> players) {
        Map<Player, Integer> playersWithScores = new HashMap<>();
        players.forEach(player -> playersWithScores.put(player, 0));
        return playersWithScores;
    }

    public void play() {
        Map<Player, Integer> playersWithScores = createMap(players);
        for (Map.Entry<Player, Integer> player1WithScore : playersWithScores.entrySet()) {
            for (Map.Entry<Player, Integer> player2WithScore : playersWithScores.entrySet()) {
                if (player1WithScore.getKey() == player2WithScore.getKey()) {
                    continue;
                }

                int result = playMatch(player1WithScore.getKey(), player2WithScore.getKey());

                if (result == 1) {
                    player1WithScore.setValue(player1WithScore.getValue() + 1);
                } else if (result == 2) {
                    player2WithScore.setValue(player2WithScore.getValue() + 1);
                }
            }
        }

        printResult(playersWithScores);
    }

    private void printResult(Map<Player, Integer> playersWithScores) {
        System.out.println();
        System.out.println("+-------------------+");
        System.out.println("| TOURNAMENT RESULT |");
        System.out.println("+-------------------+");
        System.out.println();

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

    private int playMatch(Player player1, Player player2) {

        board.reset();

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
