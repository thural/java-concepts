package data_structures.queue.priority;

import data_structures.queue.IQueue;

/**
 * Interface for a Priority Queue.
 * Elements are ordered according to their natural priority (Max-Heap).
 */
public interface IPriorityQueue extends IQueue {

    /**
     * Optional: peek() is common in Priority Queues to see
     * the highest priority element without removing it.
     */
    int peek();

    // Note: insert(), heapify(), and deleteNode() are removed from the interface
    // because they are implementation details, not public behaviors.
}