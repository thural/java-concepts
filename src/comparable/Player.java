package comparable;

//Comparable is an interface
// defining a strategy of comparing an object with other objects of the same type.
// This is called the class’s “natural ordering.”
public class Player implements Comparable<Player> {

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    private int ranking;
    private String name;
    private int age;

    public int getRanking() {
        return ranking;
    }

    // The sorting order is decided by the return value of the compareTo() method.
    // The Integer.compare(x, y) returns -1 if x is less than y, 0 if they’re equal, and 1 otherwise.
    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(getRanking(), otherPlayer.getRanking());
    }

    @Override
    public String toString() {
        return name;
    }

}
