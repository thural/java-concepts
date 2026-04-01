package data_structures.list;


public abstract class BaseList implements IList {
    protected int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    // Subclasses will implement add, remove, clear, and display differently
}
