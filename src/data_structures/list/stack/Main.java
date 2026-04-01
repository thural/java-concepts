package data_structures.list.stack;

public class Main {
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
