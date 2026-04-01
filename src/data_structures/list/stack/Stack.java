package data_structures.list.stack;


import data_structures.list.BaseList;

public class Stack extends BaseList implements IStack {
    private final int[] arr;
    private int top;
    private final int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        return arr[top--];
    }

    @Override
    public void add(int data) {
        // In a Stack context, 'add' is synonymous with 'push'
        push(data);
    }

    @Override
    public void remove(int data) {
        // This is a custom implementation to satisfy the IList interface.
        // It searches for the value and "removes" it by shifting elements down.
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (arr[i] == data) {
                // Shift elements to fill the gap
                for (int j = i; j < top; j++) {
                    arr[j] = arr[j + 1];
                }
                top--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Value " + data + " not found in stack.");
        }
    }

    @Override
    public void clear() {
        // To clear an array-based stack, we simply reset the top pointer.
        // The data still exists in memory but is now unreachable by stack operations.
        top = -1;
        System.out.println("Stack cleared.");
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

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStack();

    }
}
