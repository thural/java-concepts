package data_structures.queue.priority;

import java.util.ArrayList;

public class PriorityQueue implements IPriorityQueue {
    // We need an internal storage for the heap
    private ArrayList<Integer> hT = new ArrayList<>();

    private void heapify(int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && hT.get(l) > hT.get(largest)) largest = l;
        if (r < size && hT.get(r) > hT.get(largest)) largest = r;

        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);
            heapify(largest);
        }
    }

    @Override
    public void enQueue(int element) {
        hT.add(element);
        // "Bubble up" logic: Re-heapify from the last non-leaf node up to root
        int size = hT.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    @Override
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        int root = hT.get(0); // The highest priority element
        int lastElement = hT.get(hT.size() - 1);

        // Move the last element to root and remove the old last element
        hT.set(0, lastElement);
        hT.remove(hT.size() - 1);

        // Push the new root down to its correct position
        if (!isEmpty()) {
            heapify(0);
        }

        return root;
    }

    @Override
    public boolean isFull() {
        return false; // ArrayList based implementation is dynamic
    }

    @Override
    public int size() {
        return hT.size();
    }

    @Override
    public boolean isEmpty() {
        return hT.isEmpty();
    }

    @Override
    public void clear() {
        hT.clear();
    }

    @Override
    public void display() {
        System.out.print("PriorityQueue (Heap Array): ");
        for (Integer i : hT) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty. Cannot peek.");
            // Returning a sentinel value like -1 or throwing an exception
            // is standard if the queue is empty.
            return -1;
        }

        // In a Max-Heap, the largest element is always at the root (index 0).
        return hT.get(0);
    }
}