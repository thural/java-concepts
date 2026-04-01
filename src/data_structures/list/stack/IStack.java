package data_structures.list.stack;

import data_structures.list.vector.IVector;

/**
 * Interface for a Stack data structure.
 * Inherits Vector capabilities and adds LIFO (Last-In, First-Out) operations.
 */
public interface IStack extends IVector {
    /**
     * Pushes an item onto the top of the stack.
     * If the underlying Vector is full, it should trigger a resize.
     */
    void push(int x);

    /**
     * Removes and returns the object at the top of the stack.
     */
    int pop();

    /**
     * Returns the object at the top of the stack without removing it.
     */
    int peek();

    /**
     * Checks if the stack has reached its maximum capacity.
     * For a dynamic Vector-based stack, this usually returns false.
     */
    boolean isFull();
}