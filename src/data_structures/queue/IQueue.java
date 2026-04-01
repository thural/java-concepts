package data_structures.queue;


import data_structures.ICollection;

public interface IQueue extends ICollection {
    /**
     * Adds an element to the end of the queue.
     */
    void enQueue(int element);

    /**
     * Removes and returns the element from the front of the queue.
     */
    int deQueue();


    /**
     * Checks if the queue is full.
     */
    boolean isFull();
}
