package data_structures.list;

import data_structures.list.IList;

/**
 * Abstract base class providing common functionality for all linear structures.
 */
public abstract class BaseList implements IList {
    // Protected so that subclasses (Vector, ArrayDeque, etc.) can modify it directly
    protected int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /* Note: Methods like add(), remove(), and display() are also inherited from IList.
       Since we aren't implementing them here, they remain abstract by default
       for the subclasses to handle.
    */
}