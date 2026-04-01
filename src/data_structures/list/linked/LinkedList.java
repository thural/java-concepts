package data_structures.list.linked;


import data_structures.list.BaseList;

public class LinkedList extends BaseList implements ILinkedList {

    // Internal Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Points to the first node in the list
    private int count; // Keeps track of the size

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }

    @Override
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        count++;
    }

    @Override
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: The head node itself holds the data
        if (head.data == data) {
            head = head.next;
            count--;
            return;
        }

        // Case 2: Search for the node to delete
        Node temp = head;
        Node prev = null;
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + data + " not found.");
            return;
        }

        // Unlink the node from the list
        prev.next = temp.next;
        count--;
    }

    @Override
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(int data) {
        // Standard behavior for a list is to add to the end
        insert(data);
    }

    @Override
    public void remove(int data) {
        // Standard behavior is to remove the specified element
        delete(data);
    }

    @Override
    public void clear() {
        // In a Linked List, clearing is as simple as dropping the reference
        // to the head. The Garbage Collector will handle the rest.
        head = null;
        count = 0;
        System.out.println("List cleared.");
    }

    @Override
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insertAtBeginning(5);

        list.display(); // Output: 5 -> 10 -> 20 -> null

        System.out.println("Searching for 10: " + list.search(10));

        list.delete(10);
        list.display(); // Output: 5 -> 20 -> null
    }
}
