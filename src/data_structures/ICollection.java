package data_structures;

/**
 * Root interface for the collection hierarchy.
 * Defines basic operations available to all linear data structures (Lists, Queues, Deques).
 */
public interface ICollection {

    /**
     * Returns the total number of elements currently stored in the collection.
     * @return the number of elements.
     */
    int size();

    /**
     * Checks if the collection contains no elements.
     * @return true if the collection is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the collection, resetting it to an empty state.
     */
    void clear();

    /**
     * Prints the contents of the collection to the console in a readable format.
     */
    void display();
}