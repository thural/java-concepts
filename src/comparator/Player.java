package comparator;

public class Player {

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

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

}
