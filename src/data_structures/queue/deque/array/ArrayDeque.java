package data_structures.queue.deque.array;


import data_structures.list.BaseList;
import data_structures.queue.deque.IDeque;


public class ArrayDeque extends BaseList implements IDeque {
    private int[] elements;
    private int head;
    private int tail;
    private int capacity;

    public ArrayDeque(int initialCapacity) {
        this.capacity = initialCapacity;
        this.elements = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.count = 0; // Inherited from BaseList
    }

    private void doubleCapacity() {
        int p = head;
        int n = capacity;
        int r = n - p; // Number of elements to the right of head
        int newCapacity = n << 1; // Double the capacity
        int[] newArray = new int[newCapacity];

        // Copy elements from head to end of old array to the start of new array
        System.arraycopy(elements, p, newArray, 0, r);
        // Copy elements from start of old array to head into the new array
        System.arraycopy(elements, 0, newArray, r, p);

        this.elements = newArray;
        this.head = 0;
        this.tail = n;
        this.capacity = newCapacity;
        System.out.println("ArrayDeque resized to: " + newCapacity);
    }

    @Override
    public void insertFront(int key) {
        // Move head back circularly: (head - 1) & (capacity - 1) works if capacity is power of 2
        // We will use the more general modulo logic:
        head = (head - 1 + capacity) % capacity;
        elements[head] = key;
        count++;
        if (head == tail) {
            doubleCapacity();
        }
    }

    @Override
    public void insertRear(int key) {
        elements[tail] = key;
        tail = (tail + 1) % capacity;
        count++;
        if (tail == head) {
            doubleCapacity();
        }
    }

    @Override
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow: Deque is empty");
            return;
        }
        head = (head + 1) % capacity;
        count--;
    }

    @Override
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow: Deque is empty");
            return;
        }
        tail = (tail - 1 + capacity) % capacity;
        count--;
    }

    @Override
    public int getFront() {
        return isEmpty() ? -1 : elements[head];
    }

    @Override
    public int getRear() {
        return isEmpty() ? -1 : elements[(tail - 1 + capacity) % capacity];
    }

    @Override
    public void add(int data) {
        insertRear(data); // Standard List behavior
    }

    @Override
    public void remove(int data) {
        System.out.println("Remove(value) is inefficient in Deque; use deleteFront/Rear.");
    }

    @Override
    public void clear() {
        head = 0;
        tail = 0;
        count = 0;
    }

    @Override
    public boolean isFull() {
        return false; // Dynamic ArrayDeque is never "full"
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("ArrayDeque: ");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[(head + i) % capacity] + " ");
        }
        System.out.println();
    }
}
