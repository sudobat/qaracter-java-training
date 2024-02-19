import tictactoe.Tournament;
import tictactoe.TournamentFactory;

public class Main {

    public static void main(String[] args) {

        TournamentFactory tournamentFactory = new TournamentFactory();
        Tournament tournament = tournamentFactory.createTournament();
        tournament.play();
    }
}