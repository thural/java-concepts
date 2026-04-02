package data_structures.set;


import data_structures.ICollection;

/**
 * A collection that contains no duplicate elements.
 * Models the mathematical set abstraction.
 */
public interface ISet extends ICollection {
    /**
     * Adds the specified element.
     */
    void add(int data);

    /**
     * Checks if the set contains the specified element.
     */
    boolean contains(int data);

    /**
     * Removes the specified element from the set if it is present.
     */
    void remove(int data);
}
