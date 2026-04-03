package data_structures.map;

import java.util.Arrays;

/**
 * High-performance int-to-int HashMap implementation.
 * Uses power-of-two sizing, bitwise hashing, and manual chaining.
 */
public class HashMap implements IMap {

    protected static class Entry {
        final int key;
        int value;
        Entry next; // Manual chaining for memory efficiency

        Entry(int key, int value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    protected Entry[] buckets;
    protected int capacity;
    protected int size = 0;
    protected int threshold;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        // Ensure capacity is a power of two for bitwise optimization
        this.capacity = tableSizeFor(capacity);
        this.buckets = new Entry[this.capacity];
        this.threshold = (int) (this.capacity * LOAD_FACTOR);
    }

    /**
     * Optimized hash function: spreads higher bits to lower bits
     * and uses bitwise AND instead of modulo.
     */
    protected int getIndex(int key) {
        int h = key ^ (key >>> 16);
        return h & (capacity - 1);
    }

    @Override
    public void put(int key, int value) {
        int index = getIndex(key);
        Entry current = buckets[index];

        // 1. Check for existing key to update
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // 2. Insert new entry at the head of the bucket (Fastest)
        buckets[index] = new Entry(key, value, buckets[index]);
        size++;

        // 3. Check if resizing is needed
        if (size >= threshold) {
            resize();
        }
    }

    @Override
    public int get(int key) {
        int index = getIndex(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1; // Standard sentinel
    }

    @Override
    public void remove(int key) {
        int index = getIndex(key);
        Entry current = buckets[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private void resize() {
        int oldCapacity = capacity;
        Entry[] oldBuckets = buckets;

        capacity <<= 1; // Double capacity
        buckets = new Entry[capacity];
        threshold = (int) (capacity * LOAD_FACTOR);

        // Transfer nodes to new buckets
        for (int i = 0; i < oldCapacity; i++) {
            Entry e = oldBuckets[i];
            while (e != null) {
                Entry next = e.next;
                int newIdx = getIndex(e.key);

                // Re-link at the head of the new bucket
                e.next = buckets[newIdx];
                buckets[newIdx] = e;

                e = next;
            }
        }
    }

    /**
     * Rounds up to the nearest power of two.
     */
    private int tableSizeFor(int n) {
        int cap = n - 1;
        cap |= cap >>> 1;
        cap |= cap >>> 2;
        cap |= cap >>> 4;
        cap |= cap >>> 8;
        cap |= cap >>> 16;
        return (cap < 0) ? 1 : cap + 1;
    }

    @Override
    public boolean containsKey(int key) {
        return get(key) != -1;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
}