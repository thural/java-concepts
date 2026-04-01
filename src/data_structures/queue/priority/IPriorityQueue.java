package data_structures.queue.priority;

import data_structures.queue.IQueue;

import java.util.ArrayList;

public interface IPriorityQueue extends IQueue {
    /**
     * Maintains the max-heap property for a subtree rooted at index i.
     * Compares root with children and swaps if necessary.
     */
    void heapify(ArrayList<Integer> hT, int i);

    /**
     * Inserts a new number into the heap and re-heapifies
     * to ensure the largest element remains at the root.
     */
    void insert(ArrayList<Integer> hT, int newNum);

    /**
     * Searches for a specific value, removes it, and
     * reorganizes the remaining elements to maintain heap order.
     */
    void deleteNode(ArrayList<Integer> hT, int num);

    /**
     * Helper method to print the internal array representation of the heap.
     */
    void printArray(ArrayList<Integer> array, int size);
}