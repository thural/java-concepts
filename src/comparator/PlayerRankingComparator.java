package comparator;

import java.util.Comparator;

// The Comparator interface defines a compare(obj1, obj2) method with two compared objects,
// and works similarly to the Comparable.compareTo() method.
public class PlayerRankingComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
    }

}
