package datastructures;

import tictactoe.implementations.player.HumanPlayer;

public class MyList<T extends HumanPlayer> {

    private final Object[] internalObjects = new Object[1000];
    private int allocatedObjects = 0;

    public void add(T object) {
        internalObjects[allocatedObjects] = object;
        allocatedObjects++;
    }
}
