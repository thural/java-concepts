package data_structures.list.stack;

import data_structures.list.IList;

public interface IStack extends IList {
    /**
     * Pushes an element onto the top of the stack.
     */
    void push(int x);

    /**
     * Removes and returns the element at the top of the stack.
     */
    int pop();

    /**
     * Returns the number of elements currently in the stack.
     */
    int size();

    /**
     * Checks if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Checks if the stack has reached its maximum capacity.
     */
    boolean isFull();

    /**
     * Prints all elements in the stack.
     */
    void printStack();
}
