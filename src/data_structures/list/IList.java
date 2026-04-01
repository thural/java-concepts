package data_structures.list;


import data_structures.ICollection;

public interface IList extends ICollection {
    /** Adds an element to the collection. */
    void add(int data);

    /** Removes an element from the collection. */
    void remove(int data);
}
