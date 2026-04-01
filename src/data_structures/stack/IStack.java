package data_structures.stack;

public interface IStack {
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
    Boolean isEmpty();

    /**
     * Checks if the stack has reached its maximum capacity.
     */
    Boolean isFull();

    /**
     * Prints all elements in the stack.
     */
    void printStack();
}
