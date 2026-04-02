package data_structures.map;

import java.util.LinkedList;

/**
 * Hash table based implementation of the IMap interface.
 * This implementation provides all the optional map operations.
 * It makes no guarantees as to the order of the map.
 */
public class HashMap implements IMap {

    // Entry class to store the Key-Value pair
    protected static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    protected LinkedList<Entry>[] buckets;
    protected int capacity;
    protected int size = 0;
    private static final double LOAD_FACTOR = 0.75;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    protected int hash(int key) {
        return Math.abs(key) % capacity;
    }

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

        // In a full JCF implementation, we would check for rehash() here
    }

    @Override
    public int get(int key) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) return entry.value;
        }
        return -1; // Standard "Not Found" sentinel for int-based maps
    }

    @Override
    public void remove(int key) {
        int index = hash(key);
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
            if (entry.key == key) return true;
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
        for (LinkedList<Entry> bucket : buckets) {
            bucket.clear();
        }
        size = 0;
    }
}