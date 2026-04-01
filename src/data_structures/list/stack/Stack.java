package data_structures.list.stack;

import data_structures.list.vector.Vector;


public class Stack extends Vector implements IStack {

    /**
     * Initializes the stack with an initial capacity.
     * Because it extends Vector, it will grow automatically.
     */
    public Stack(int size) {
        super(size); // Calls the Vector constructor
    }

    @Override
    public void push(int x) {
        // Reuse Vector's add method which handles capacity checks and resizing
        add(x);
        System.out.println("Inserting " + x);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        // The top element is always at index (count - 1)
        int value = arr[count - 1];
        count--; // Decrement count inherited from BaseList via Vector
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        return arr[count - 1];
    }

    @Override
    public void add(int data) {
        // Keeps the IList 'add' synonymous with 'push'
        push(data);
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (bottom to top):");
        printStack();
    }

    @Override
    public boolean isFull() {
        // Since Vector is dynamic, the stack is technically never full
        return false;
    }

    public void printStack() {
        // Using 'count' from the parent class to iterate
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        // Starting with a small capacity of 2 to demonstrate dynamic growth
        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(2);
        stack.push(3); // Vector will automatically double capacity here
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStack();
    }
}