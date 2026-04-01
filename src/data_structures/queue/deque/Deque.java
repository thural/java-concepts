package data_structures.queue.deque;

/**
 * Implementation of a Circular Double-Ended Queue (Deque).
 * Leverages the default bridge methods from IDeque for standard Queue operations.
 */
public class Deque implements IDeque {
    private final int[] arr;
    private int front;
    private int rear;
    private final int size; // Maximum capacity of this deque

    public Deque(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = 0;
        this.size = size;
    }

    @Override
    public boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    @Override
    public boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }
        arr[front] = key;
    }

    @Override
    public void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = key;
    }

    @Override
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        if (front == rear) { // Last element removed
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size; // Simplified wrap-around
        }
    }

    @Override
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        if (front == rear) { // Last element removed
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    @Override
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    @Override
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }
        int i = front;
        System.out.print("Current Deque: ");
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}