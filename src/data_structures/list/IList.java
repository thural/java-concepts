package data_structures.list;


public interface IList {
    /** Adds an element to the collection. */
    void add(int data);

    /** Removes an element from the collection. */
    void remove(int data);

    /** Returns the current number of elements. */
    int size();

    /** Returns true if the collection has no elements. */
    boolean isEmpty();

    /** Clears all elements from the collection. */
    void clear();

    /** Prints the collection to the console. */
    void display();
}
