package data_structures.set.sorted;

import data_structures.set.ISet;

/**
 * A Set that further provides a total ordering on its elements.
 * Elements are ordered using their natural ordering (ascending).
 */
public interface ISortedSet extends ISet {

    /**
     * Returns the first (lowest) element currently in this set.
     * @return the smallest integer in the set.
     */
    int first();

    /**
     * Returns the last (highest) element currently in this set.
     * @return the largest integer in the set.
     */
    int last();

    /**
     * Returns a view of the portion of this set whose elements range
     * from fromElement, inclusive, to toElement, exclusive.
     */
    ISortedSet subSet(int fromElement, int toElement);

    /**
     * Returns a view of the portion of this set whose elements are
     * strictly less than toElement.
     */
    ISortedSet headSet(int toElement);

    /**
     * Returns a view of the portion of this set whose elements are
     * greater than or equal to fromElement.
     */
    ISortedSet tailSet(int fromElement);
}