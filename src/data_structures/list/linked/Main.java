package data_structures.list.linked;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.addAtBeginning(5);

        list.display(); // Output: 5 -> 10 -> 20 -> null

        System.out.println("Searching for 10: " + list.search(10));

        list.remove(10);
        list.display(); // Output: 5 -> 20 -> null
    }
}
