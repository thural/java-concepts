package data_structures.list.vector;

import data_structures.list.BaseList;
import java.util.Arrays;

public class Vector extends BaseList implements IVector {
    protected int[] arr;
    protected int capacity;

    public Vector(int initialCapacity) {
        this.capacity = initialCapacity;
        this.arr = new int[capacity];
        this.count = 0;
    }

    private void ensureCapacity() {
        if (count == capacity) {
            capacity = capacity * 2;
            arr = Arrays.copyOf(arr, capacity);
            System.out.println("Capacity doubled to: " + capacity);
        }
    }

    @Override
    public void add(int data) {
        ensureCapacity();
        arr[count++] = data;
    }

    @Override
    public void addAt(int index, int data) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException();
        ensureCapacity();
        // Shift elements to the right
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
        count++;
    }

    @Override
    public void remove(int data) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == data) {
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                count--;
                return;
            }
        }
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public void set(int index, int data) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        arr[index] = data;
    }

    @Override
    public void clear() {
        count = 0;
    }

    @Override
    public void display() {
        System.out.print("Vector: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
