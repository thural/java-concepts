package data_structures.map;

import java.util.LinkedList;

public class HashTable implements IMap {
    private class Entry {
        int key, value;
        Entry(int k, int v) { this.key = k; this.value = v; }
    }

    private LinkedList<Entry>[] buckets;
    private int capacity;
    private int size = 0;

    public HashTable(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new LinkedList<>();
    }

    private int hash(int key) { return Math.abs(key) % capacity; }

    @Override
    public void put(int key, int value) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value; // Update existing key
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
        size++;
    }

    @Override
    public int get(int key) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) return entry.value;
        }
        return -1; // Or throw Exception
    }

    @Override
    public void remove(int key) {
        int index = hash(key);
        // We use an Iterator or a simple loop to find the entry in the bucket
        Entry toRemove = null;
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            buckets[index].remove(toRemove);
            size--;
        }
    }

    @Override
    public boolean containsKey(int key) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        // Clear each individual bucket list to free memory
        for (int i = 0; i < capacity; i++) {
            buckets[i].clear();
        }
        size = 0;
    }
}