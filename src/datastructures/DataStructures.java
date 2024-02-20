package datastructures;

import tictactoe.Player;
import tictactoe.implementations.BoardImplementation;
import tictactoe.implementations.player.*;

import java.util.*;

public class DataStructures {

    public void demoDataStructures() {
        int i = 1;
        double x = 0.333;
        float f = 0.23f;
        boolean is = false;
        char c = 'a';

        char[] word = {'h', 'o', 'l', 'a'};

        String word2 = "hola";

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        List<Integer> numberList = new ArrayList<>() {{
            add(1);
            add(3);
            add(5);
            add(7);
            add(9);
        }};

        numberList.sort(Comparator.reverseOrder());

//        numberList.forEach(System.out::println);

        /**
         * (
         * 0,
         * 1,
         * 2,
         * 3,
         * )
         */

        List<Player> players = new ArrayList<>() {{
            add(new JavierBotPlayer());
            add(new BrendaBotPlayer());
            add(new MatiasBotPlayer());
            add(new AdriaBotPlayer());
        }};

        players.add(new ElioBotPlayer());



        players.stream()
                .sorted(Comparator.comparing(p -> p.getClass().getSimpleName()))
                .map(player -> player.getClass().getSimpleName())
                .forEach(System.out::println);

        /**
         * (elemento1) <-> (elemento2) <-> (elemento3) <-> (elemento4)
         * linkedList -> head() (elemento1) -> next() (elemento2)
         *
         */

        /**
         * Añadir un elemento a la mitad
         *
         * Con un array
         *
         * ["Javier", "Brenda", "Matias", "Adria", null, null, null, null, null]
         * ["Javier", "Brenda", "Elio", null, null, ...]
         * ["Javier", "Brenda", "Elio", "Matias", "Adria", null, null, ...]
         *
         * Con una Linked List
         *
         * Node("Javier", null, Ref("Brenda"))
         * Node("Brenda", Ref("Javier"), Ref("Matias"))
         * Node("Matias", Ref("Brenda"), Ref("Adria"))
         * Node("Adria", Ref("Matias"), null)
         *
         * Node("Javier", null, Ref("Brenda"))
         * Node("Brenda", Ref("Javier"), Ref("Elio"))
         *
         * Node("Elio", Ref("Brenda"), Ref("Matias"))
         *
         * Node("Matias", Ref("Elio"), Ref("Adria"))
         * Node("Adria", Ref("Matias"), null)
         *
         *
         *
         */

        List<Player> playersLinked = new LinkedList<>() {{
            add(new JavierBotPlayer());
            add(new BrendaBotPlayer());
            add(new MatiasBotPlayer());
            add(new AdriaBotPlayer());
        }};

        /**
         * {
         *   'a': 14,
         *   'b': 3,
         *   'f': 92,
         * }
         */

        List<String> playersList = new ArrayList<>() {{
            add("Javier");
            add("Brenda");
            add("Matias");
            add("Adria");
        }};

        for (String player : playersList) {
            if (player == "Adria") {

            }
        }

        Map<String, Integer> playersWithScores = new HashMap<>() {{
            put("Javier", 0);
            put("Brenda", 0);
            put("Matias", 0);
            put("Adria", 0);
        }};

        playersWithScores.get("Adria");

        playersWithScores.put("Elio", 1);

        playersWithScores.remove("Elio");

//        players.sort(Comparator.comparing(p -> p.getClass().getSimpleName()));
//        players.forEach(System.out::println);
//
//        for (Player player : players) {
//            player.makeMove(new BoardImplementation(), 1);
//        }


    }
}
