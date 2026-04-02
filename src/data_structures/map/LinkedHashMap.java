package data_structures.map;

import java.util.ArrayList;
import java.util.List;

public class LinkedHashMap extends HashMap {
    private List<Integer> keysInOrder = new ArrayList<>();

    public LinkedHashMap(int capacity) {
        super(capacity);
    }

    @Override
    public void put(int key, int value) {
        if (!containsKey(key)) {
            keysInOrder.add(key);
        }
        super.put(key, value);
    }

    @Override
    public void remove(int key) {
        super.remove(key);
        keysInOrder.remove((Integer) key);
    }

    @Override
    public void clear() {
        super.clear(); // Clears the hash buckets
        keysInOrder.clear(); // Clears the insertion order record
    }

    /** * Since this is a LINKED map, we need a way to display
     * the elements in the correct order.
     */
    public void display() {
        System.out.print("LinkedHashMap (Ordered): { ");
        for (int key : keysInOrder) {
            System.out.print(key + "=" + get(key) + " ");
        }
        System.out.println("}");
    }
}