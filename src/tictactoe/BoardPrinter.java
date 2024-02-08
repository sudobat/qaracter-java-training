package tictactoe;

/**
 * Author: Javier Nakama
 */
public class BoardPrinter {
    public void print(Board board) {
        int [] entryData = board.getState();
        char [] entryDataToChar = new char[9];
        for(int i=0; i < 9 ;i++){
            switch (entryData[i]){
                case 0 -> entryDataToChar[i]= ' ';
                case 1 -> entryDataToChar[i]= 'O';
                case 2 -> entryDataToChar[i]= 'X';
            }
        }
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ " + entryDataToChar[0] + " │ " + entryDataToChar[1] + " │ " + entryDataToChar[2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + entryDataToChar[3] + " │ " + entryDataToChar[4] + " │ " + entryDataToChar[5] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + entryDataToChar[6] + " │ " + entryDataToChar[7] + " │ " + entryDataToChar[8] + " │");
        System.out.println("└───┴───┴───┘");
    }
}
