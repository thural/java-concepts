package data_structures.queue.circular;

import data_structures.queue.IQueue;

public interface ICircularQueue extends IQueue {
    /**
     * Checks if the queue is empty (front is -1).
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     * This occurs if front is 0 and rear is SIZE-1, or if front is rear + 1.
     */
    boolean isFull();

    /**
     * Displays the current state of the queue, showing front/rear indices
     * and traversing the elements in their logical order.
     */
    void display();
}