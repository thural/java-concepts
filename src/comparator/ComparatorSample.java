package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSample {
    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(75, "John", 20);
        Player player2 = new Player(67, "Roger", 18);
        Player player3 = new Player(45, "Steven", 24);

        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        PlayerRankingComparator playerRankingComparator = new PlayerRankingComparator();

        // sorting and displaying by player ranking using the custom comparator
        System.out.println("Before Sorting by ranking: " + footballTeam);
        Collections.sort(footballTeam, playerRankingComparator);
        System.out.println("After Sorting by ranking: " + footballTeam);
    }
}
