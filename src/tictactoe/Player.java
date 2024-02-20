package tictactoe;

public interface Player {
    String makeMove(ReadOnlyBoard board, int myTurn);
}
