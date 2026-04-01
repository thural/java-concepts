package data_structures.queue.priority;

public class Main {
    public static void main(String[] args) {
        // 1. Program to the Interface, not the Implementation
        IPriorityQueue pq = new PriorityQueue();

        System.out.println("--- Testing Priority Queue (Max-Heap) ---");

        // 2. Use standard Queue methods (Self-contained logic)
        pq.enQueue(3);
        pq.enQueue(4);
        pq.enQueue(9);
        pq.enQueue(5);
        pq.enQueue(2);

        // 3. Display internal state (inherited from ICollection)
        pq.display();

        // 4. Test peek() - Should show the largest (9)
        System.out.println("Highest priority element (peek): " + pq.peek());

        // 5. Test deQueue() - Should remove and return 9
        System.out.println("Removing element (deQueue): " + pq.deQueue());

        System.out.print("After deQueue: ");
        pq.display();

        // 6. Demonstrate metadata methods
        System.out.println("Current size: " + pq.size());
        System.out.println("Is empty? " + pq.isEmpty());

        // 7. Clear the queue
        pq.clear();
        System.out.println("After clear, size: " + pq.size());
    }
}