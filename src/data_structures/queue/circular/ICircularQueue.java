package data_structures.queue.circular;

import data_structures.queue.IQueue;

public interface ICircularQueue extends IQueue {
    /**
     * Inserts an element at the rear of the queue.
     * If the rear reaches the end of the array, it wraps around to the beginning.
     */
    void enQueue(int element);

    /**
     * Removes and returns the element from the front of the queue.
     * If the front reaches the end of the array, it wraps around to the beginning.
     */
    int deQueue();

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