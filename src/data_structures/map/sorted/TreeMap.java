package data_structures.map.sorted;


public class TreeMap implements ISortedMap {
    private Node root;
    private int size = 0;

    private class Node {
        int key, value;
        Node left, right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(int key, int value) {
        if (!containsKey(key)) size++;
        root = putRecursive(root, key, value);
    }

    private Node putRecursive(Node current, int key, int value) {
        if (current == null) return new Node(key, value);
        if (key < current.key) current.left = putRecursive(current.left, key, value);
        else if (key > current.key) current.right = putRecursive(current.right, key, value);
        else current.value = value; // Update value if key exists
        return current;
    }

    @Override
    public int get(int key) {
        Node res = find(root, key);
        return (res != null) ? res.value : -1;
    }

    private Node find(Node current, int key) {
        if (current == null || current.key == key) return current;
        return (key < current.key) ? find(current.left, key) : find(current.right, key);
    }

    @Override
    public boolean containsKey(int key) {
        return find(root, key) != null;
    }

    @Override
    public int firstKey() {
        if (root == null) return -1;
        Node current = root;
        while (current.left != null) current = current.left;
        return current.key;
    }

    @Override
    public int lastKey() {
        if (root == null) return -1;
        Node current = root;
        while (current.right != null) current = current.right;
        return current.key;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void remove(int key) {
        // Logic similar to TreeSet remove, but moving Entry nodes
    }

    // Range methods (subMap, headMap, tailMap) would use
    // the same traversal logic as TreeSet.
    @Override
    public ISortedMap subMap(int fromKey, int toKey) {
        TreeMap result = new TreeMap();
        fillRange(root, result, fromKey, toKey);
        return result;
    }

    private void fillRange(Node node, TreeMap res, int min, int max) {
        if (node == null) return;
        if (node.key > min) fillRange(node.left, res, min, max);
        if (node.key >= min && node.key < max) res.put(node.key, node.value);
        if (node.key < max) fillRange(node.right, res, min, max);
    }

    @Override
    public ISortedMap headMap(int toKey) { return subMap(Integer.MIN_VALUE, toKey); }

    @Override
    public ISortedMap tailMap(int fromKey) { return subMap(fromKey, Integer.MAX_VALUE); }
}
