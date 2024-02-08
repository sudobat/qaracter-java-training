package tictactoe;

/**
 * Author Matias Rotmistrovsky
 */
public class Arbiter {
    /**
     * Si result vale 1, ha ganado el jugador 1
     * Si result vale 2, ha ganado el jugador 2
     * Si result vale 0, ha resultado en empate
     * Si result vale -1, el juego sigue.
     */

    private boolean checkCompletion(Board board) {
        boolean finished = false;
        int numberOfPositions = 0;

        for (int boardPosition : board.getState()) {
            if (boardPosition != 0) {
                numberOfPositions++;
            }
        }
        if (numberOfPositions == 9) {
            finished = true;
        }

        return finished;
    }

    private int CheckWinner(Board board) {

        int[] boardState = board.getState();
        /*HORIZONTAL*/
        if (boardState[0] == boardState[1] && boardState[1] == boardState[2] && boardState[0] != 0) {
            return boardState[0];
        }
        if (boardState[3] == boardState[4] && boardState[4] == boardState[5] && boardState[3] != 0) {
            return boardState[3];
        }
        if (boardState[6] == boardState[7] && boardState[6] == boardState[8] && boardState[6] != 0) {
            return boardState[6];
        }

        /*VERTICAL*/
        if (boardState[0] == boardState[3] && boardState[0] == boardState[6] && boardState[0] != 0) {
            return boardState[0];
        }
        if (boardState[1] == boardState[4] && boardState[1] == boardState[7] && boardState[1] != 0) {
            return boardState[1];
        }
        if (boardState[2] == boardState[5] && boardState[2] == boardState[8] && boardState[2] != 0) {
            return boardState[2];
        }

        /*DIAGONAL*/
        if (boardState[0] == boardState[4] && boardState[0] == boardState[8] && boardState[0] != 0) {
            return boardState[0];
        }
        if (boardState[2] == boardState[4] && boardState[2] == boardState[6] && boardState[2] != 0) {
            return boardState[2];
        }

        return 0;
    }

    public int checkIfGameIsFinished(Board board) {
        int winner = CheckWinner(board);
        if (checkCompletion(board)) {
            return winner;
        }
        if (winner > 0) {
            return winner;
        }

        return -1;

    }
}
