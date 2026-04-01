package data_structures.queue.dequeue;

import data_structures.queue.IQueue;

/**
 * Interface for a Double-Ended Queue (Deque).
 * Supports insertion and removal from both ends.
 */
public interface IDeque extends IQueue {
    /**
     * Inserts an element at the front of the Deque.
     * Wraps around to the end of the array if necessary.
     */
    void insertFront(int key);

    /**
     * Inserts an element at the rear of the Deque.
     * Wraps around to the beginning of the array if necessary.
     */
    void insertRear(int key);

    /**
     * Removes the element currently at the front.
     */
    void deleteFront();

    /**
     * Removes the element currently at the rear.
     */
    void deleteRear();

    /**
     * Retrieves the front element without removing it.
     */
    int getFront();

    /**
     * Retrieves the rear element without removing it.
     */
    int getRear();

    /**
     * Checks if the Deque has no elements.
     */
    boolean isEmpty();

    /**
     * Checks if the Deque has reached its capacity.
     */
    boolean isFull();
}