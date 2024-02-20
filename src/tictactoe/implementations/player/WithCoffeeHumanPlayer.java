package tictactoe.implementations.player;

import tictactoe.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WithCoffeeHumanPlayer extends HumanPlayer implements Player {

    private final BufferedReader reader;

    public WithCoffeeHumanPlayer() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void makeCoffee() {
        System.out.println("Here is your coffee.");
    }
}
