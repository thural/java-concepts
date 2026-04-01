package data_structures.queue.deque;

import data_structures.queue.IQueue;

/**
 * Interface for a Double-Ended Queue (Deque).
 * Extends IQueue to allow Deques to be used anywhere a standard Queue is expected.
 */
public interface IDeque extends IQueue {

    /**
     * Inserts an element at the front of the Deque.
     */
    void insertFront(int key);

    /**
     * Inserts an element at the rear of the Deque.
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
     * Maps the standard Queue enQueue to the Deque's insertRear.
     */
    @Override
    default void enQueue(int element) {
        insertRear(element);
    }

    /**
     * Maps the standard Queue deQueue to the Deque's front operations.
     * Note: Since IQueue.deQueue() returns an int, we fetch the front value first.
     */
    @Override
    default int deQueue() {
        int value = getFront();
        deleteFront();
        return value;
    }

    /* Note: isEmpty(), isFull(), and display() are inherited from IQueue.
       They do not need to be redeclared here unless you want to add specific documentation.
    */
}