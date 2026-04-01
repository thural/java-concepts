package data_structures.list.linked;


import data_structures.list.IList;

public interface ILinkedList extends IList {
    /**
     * Adds a new node with the given data to the end of the list.
     */
    void insert(int data);

    /**
     * Adds a new node at the very beginning of the list.
     */
    void insertAtBeginning(int data);

    /**
     * Removes the first occurrence of a node containing the specified data.
     */
    void delete(int data);

    /**
     * Searches for a value in the list. Returns true if found.
     */
    boolean search(int key);

    /**
     * Returns the number of nodes in the list.
     */
    int size();

    /**
     * Prints the list elements in order (e.g., 10 -> 20 -> 30 -> null).
     */
    void display();
}
