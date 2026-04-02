package data_structures.map;

/**
 * Key-Value pair collection. Duplicate keys are not allowed.
 */
public interface IMap {

    /** Associates value with key. Overwrites if key exists. */
    void put(int key, int value);

    /** Returns value for key, or -1 if not found. */
    int get(int key);

    /** Removes the mapping for the given key. */
    void remove(int key);

    /** Checks if a mapping exists for the key. */
    boolean containsKey(int key);

    /** Returns the number of mappings. */
    int size();

    /** True if size is 0. */
    boolean isEmpty();

    /** Removes all mappings. */
    void clear();
}