package data_structures.queue;


public interface IQueue {
    /**
     * Adds an element to the end of the queue.
     */
    void enQueue(int element);

    /**
     * Removes and returns the element from the front of the queue.
     */
    int deQueue();

    /**
     * Checks if the queue is empty.
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     */
    boolean isFull();

    /**
     * Displays the current elements and the front/rear pointers.
     */
    void display();
}
