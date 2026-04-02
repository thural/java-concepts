package data_structures.set;

import java.util.LinkedList;

public class HashSet implements ISet {
    private final LinkedList<Integer>[] buckets;
    private final int capacity;
    protected int count = 0; // Tracking size independently
    private static final double LOAD_FACTOR = 0.75;

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int data) {
        return Math.abs(data) % capacity;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void add(int data) {
        if (contains(data)) return; // Unique elements only

        int index = hash(data);
        buckets[index].add(data);
        count++;
    }

    @Override
    public boolean contains(int data) {
        int index = hash(data);
        return buckets[index].contains(data);
    }

    @Override
    public void remove(int data) {
        int index = hash(data);
        if (buckets[index].remove((Integer) data)) {
            count--;
        }
    }

    @Override
    public void clear() {
        for (LinkedList<Integer> bucket : buckets) {
            bucket.clear();
        }
        count = 0;
    }

    @Override
    public void display() {
        System.out.print("HashSet: { ");
        for (LinkedList<Integer> bucket : buckets) {
            for (int val : bucket) {
                System.out.print(val + " ");
            }
        }
        System.out.println("}");
    }
}