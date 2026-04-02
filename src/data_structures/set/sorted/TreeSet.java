package data_structures.set.sorted;


public class TreeSet implements ISortedSet {
    private Node root;
    private int count = 0;

    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    @Override
    public int size() { return count; }

    @Override
    public boolean isEmpty() { return count == 0; }

    @Override
    public void add(int data) {
        if (!contains(data)) {
            root = addRecursive(root, data);
            count++;
        }
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) return new Node(data);
        if (data < current.data) current.left = addRecursive(current.left, data);
        else if (data > current.data) current.right = addRecursive(current.right, data);
        return current;
    }

    @Override
    public boolean contains(int data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node current, int data) {
        if (current == null) return false;
        if (data == current.data) return true;
        return data < current.data
                ? containsRecursive(current.left, data)
                : containsRecursive(current.right, data);
    }

    @Override
    public int first() {
        if (isEmpty()) return -1;
        Node current = root;
        while (current.left != null) current = current.left;
        return current.data;
    }

    @Override
    public int last() {
        if (isEmpty()) return -1;
        Node current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    @Override
    public ISortedSet subSet(int fromElement, int toElement) {
        TreeSet result = new TreeSet();
        fillRange(root, result, fromElement, toElement);
        return result;
    }

    @Override
    public ISortedSet headSet(int toElement) {
        // From the very beginning up to (but not including) toElement
        return subSet(Integer.MIN_VALUE, toElement);
    }

    @Override
    public ISortedSet tailSet(int fromElement) {
        // From fromElement to the very end
        return subSet(fromElement, Integer.MAX_VALUE);
    }

    /**
     * Helper method to perform a range-constrained In-Order Traversal.
     * This is O(n) in the worst case, but optimized to skip irrelevant subtrees.
     */
    private void fillRange(Node node, TreeSet resultSet, int min, int max) {
        if (node == null) return;

        // If current node's data is greater than min, there might be
        // more valid elements in the left subtree.
        if (node.data > min) {
            fillRange(node.left, resultSet, min, max);
        }

        // If current node is within [min, max), add it.
        if (node.data >= min && node.data < max) {
            resultSet.add(node.data);
        }

        // If current node's data is less than max, there might be
        // more valid elements in the right subtree.
        if (node.data < max) {
            fillRange(node.right, resultSet, min, max);
        }
    }

    @Override
    public void clear() {
        root = null;
        count = 0;
    }

    @Override
    public void display() {
        System.out.print("TreeSet (Sorted): { ");
        inOrderTraversal(root);
        System.out.println("}");
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    @Override
    public void remove(int data) {
        if (contains(data)) {
            root = removeRecursive(root, data);
            count--;
        }
    }

    private Node removeRecursive(Node current, int data) {
        if (current == null) return null;

        // 1. Navigate to the node to be deleted
        if (data < current.data) {
            current.left = removeRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = removeRecursive(current.right, data);
        } else {
            // Found the node! Handle the 3 cases:

            // Case 1 & 2: No child or only one child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Case 3: Two children
            // Find the smallest value in the right subtree (In-Order Successor)
            current.data = findMin(current.right);

            // Delete the In-Order Successor
            current.right = removeRecursive(current.right, current.data);
        }
        return current;
    }

    private int findMin(Node node) {
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }
}
