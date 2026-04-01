package data_structures.queue.deque.array;


import data_structures.queue.deque.Deque;
import data_structures.queue.deque.IDeque;
import data_structures.queue.IQueue;

public class Main {
    public static void main(String[] args) {
        // Create a Deque with a capacity of 5
        // Using the interface as the type (Polymorphism)
        IDeque myDeque = new Deque(5);

        System.out.println("--- Double-Ended Operations ---");

        myDeque.insertRear(10);  // Deque: [10]
        myDeque.insertRear(20);  // Deque: [10, 20]
        myDeque.insertFront(5);  // Deque: [5, 10, 20]
        myDeque.insertFront(1);  // Deque: [1, 5, 10, 20]

        myDeque.display();

        System.out.println("Front element: " + myDeque.getFront());
        System.out.println("Rear element: " + myDeque.getRear());

        myDeque.deleteFront();   // Removes 1
        myDeque.deleteRear();    // Removes 20

        System.out.print("After deletions (Front and Rear): ");
        myDeque.display();       // Expected: [5, 10]

        System.out.println("\n--- Standard Queue Operations (Inherited) ---");

        // We can treat our Deque specifically as an IQueue!
        IQueue myQueue = myDeque;

        myQueue.enQueue(30);     // Uses default insertRear logic
        myQueue.enQueue(40);     // Uses default insertRear logic

        System.out.print("Using as a Queue: ");
        myQueue.display();       // Expected: [5, 10, 30, 40]

        int removed = myQueue.deQueue(); // Uses default getFront + deleteFront logic
        System.out.println("DeQueued element: " + removed);

        System.out.print("Final State: ");
        myQueue.display();

        System.out.println("\n--- Edge Case Checks ---");
        System.out.println("Is Full? " + myDeque.isFull());

        myDeque.enQueue(50);
        myDeque.enQueue(60); // This should trigger the Overflow message from our logic
    }
}