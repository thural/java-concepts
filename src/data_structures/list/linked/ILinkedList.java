package data_structures.list.linked;


import data_structures.list.IList;

public interface ILinkedList extends IList {

    /**
     * Adds a new node at the very beginning of the list.
     */
    void addAtBeginning(int data);

    /**
     * Searches for a value in the list. Returns true if found.
     */
    boolean search(int key);
}
