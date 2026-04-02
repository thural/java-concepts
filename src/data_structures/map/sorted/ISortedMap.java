package data_structures.map.sorted;


import data_structures.map.IMap;

/**
 * A Map that provides a total ordering on its keys.
 * Keys are ordered using their natural ordering (ascending).
 */
public interface ISortedMap extends IMap {

    /** Returns the first (lowest) key. */
    int firstKey();

    /** Returns the last (highest) key. */
    int lastKey();

    /** Returns a view of the portion of this map whose keys range from fromKey to toKey. */
    ISortedMap subMap(int fromKey, int toKey);

    /** Returns a view of the portion of this map whose keys are strictly less than toKey. */
    ISortedMap headMap(int toKey);

    /** Returns a view of the portion of this map whose keys are greater than or equal to fromKey. */
    ISortedMap tailMap(int fromKey);
}
