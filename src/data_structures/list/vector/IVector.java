package data_structures.list.vector;

import data_structures.list.IList;

/**
 * Interface for a dynamic, resizable array (Vector).
 * Adds index-based access and manipulation to the base List.
 */
public interface IVector extends IList {
    /**
     * Inserts an element at a specific position.
     * Shifts subsequent elements to the right.
     */
    void addAt(int index, int data);

    /**
     * Returns the element at the specified index without removing it.
     */
    int get(int index);

    /**
     * Replaces the element at the specified index with a new value.
     */
    void set(int index, int data);
}
