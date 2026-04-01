package data_structures.list.vector;


import data_structures.list.IList;

public class Main {
    public static void main(String[] args) {
        // 1. Initialization with a small capacity to test growth logic
        // Using IVector interface for flexibility
        IVector myVector = new Vector(2);

        System.out.println("--- Testing Dynamic Growth ---");
        myVector.add(10);
        myVector.add(20);

        // This third add will trigger ensureCapacity() and double the size
        myVector.add(30);
        myVector.display(); // Output: Vector: 10 20 30

        System.out.println("\n--- Testing Index-based Insertion ---");
        // Insert 15 at index 1 (between 10 and 20)
        myVector.addAt(1, 15);
        myVector.display(); // Output: Vector: 10 15 20 30

        System.out.println("\n--- Testing Get and Set ---");
        System.out.println("Element at index 2: " + myVector.get(2)); // 20
        myVector.set(2, 25);
        System.out.println("After setting index 2 to 25:");
        myVector.display(); // Output: Vector: 10 15 25 30

        System.out.println("\n--- Testing Removal ---");
        // Removes the first occurrence of '15'
        myVector.remove(15);
        myVector.display(); // Output: Vector: 10 25 30

        System.out.println("\n--- Testing Polymorphism (IList) ---");
        // Treat the Vector as a generic IList
        IList simpleList = (IList) myVector;
        System.out.println("Current Size: " + simpleList.size());

        simpleList.clear();
        System.out.println("After Clear, is empty? " + simpleList.isEmpty());
        simpleList.display();
    }
}