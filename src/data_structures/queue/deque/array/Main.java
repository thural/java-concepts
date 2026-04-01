package data_structures.queue.deque.array;


import data_structures.queue.deque.IDeque;
import data_structures.queue.IQueue;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize with a very small capacity (2) to trigger resizing logic
        IDeque adq = new ArrayDeque(2);

        System.out.println("--- Testing Double-Ended Insertion & Dynamic Growth ---");

        adq.insertRear(10);
        adq.insertRear(20); // Array is now full [10, 20]

        System.out.println("Current count: " + adq.size());

        // This next insert triggers doubleCapacity()
        adq.insertFront(5);
        adq.insertRear(30);

        adq.display(); // Expected: ArrayDeque: 5 10 20 30

        System.out.println("\n--- Testing Wraparound and Deletion ---");

        System.out.println("Front element: " + adq.getFront()); // 5
        System.out.println("Rear element: " + adq.getRear());   // 30

        adq.deleteFront(); // Removes 5
        adq.deleteRear();  // Removes 30

        System.out.print("After deleting from both ends: ");
        adq.display(); // Expected: 10 20

        System.out.println("\n--- Using as a Standard Queue (Inherited/Bridge) ---");

        // Treating ArrayDeque as an IQueue to test polymorphic behavior
        IQueue queue = adq;

        queue.enQueue(100);
        queue.enQueue(200);
        queue.enQueue(300); // Should trigger another resize since count was 2

        queue.display();
        System.out.println("deQueue result: " + queue.deQueue()); // Should be 10

        System.out.println("\n--- Final Status ---");
        System.out.println("Is Empty? " + adq.isEmpty());
        System.out.println("Total elements (count): " + adq.size());
        adq.display();

        adq.clear();
        System.out.println("After clear(), size is: " + adq.size());
    }
}
