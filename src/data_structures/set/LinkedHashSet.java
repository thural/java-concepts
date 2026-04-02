package data_structures.set;


import java.util.ArrayList;
import java.util.List;

/**
 * Hash table and linked list implementation of the ISet interface.
 * Maintains insertion order.
 */
public class LinkedHashSet extends HashSet {
    // Stores the order of insertion
    private List<Integer> iterationOrder;

    public LinkedHashSet(int capacity) {
        super(capacity);
        iterationOrder = new ArrayList<>();
    }

    @Override
    public void add(int data) {
        if (contains(data)) return;

        super.add(data); // Add to the hash buckets
        iterationOrder.add(data); // Record the order
    }

    @Override
    public void remove(int data) {
        if (contains(data)) {
            super.remove(data);
            iterationOrder.remove((Integer) data);
        }
    }

    @Override
    public void clear() {
        super.clear();
        iterationOrder.clear();
    }

    @Override
    public void display() {
        System.out.print("LinkedHashSet (Ordered): { ");
        for (int val : iterationOrder) {
            System.out.print(val + " ");
        }
        System.out.println("}");
    }
}
