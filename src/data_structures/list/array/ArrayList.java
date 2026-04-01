package data_structures.list.array;

import data_structures.list.BaseList;
import data_structures.list.IList;

import java.util.Arrays;

public class ArrayList extends BaseList implements IList {
    private int[] array;

    public ArrayList(int initialCapacity) {
        this.array = new int[initialCapacity];
        this.count = 0; // count is inherited from BaseList
    }

    @Override
    public void add(int elem) {
        assureCapacity();
        array[count++] = elem;
    }

    // Overloaded add for index-specific insertion
    public void add(int index, int elem) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException();
        assureCapacity();
        // Shift elements to the right to make a hole
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = elem;
        count++;
    }

    @Override
    public void remove(int data) {
        int index = indexOf(data);
        if (index != -1) {
            removeAt(index);
        }
    }

    public int removeAt(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        int removedElement = array[index];

        // Instead of creating a new array, we just shift elements left
        int numMoved = count - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        count--;
        return removedElement;
    }

    public int get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public int indexOf(int elem) {
        for (int i = 0; i < count; i++) {
            if (array[i] == elem) return i;
        }
        return -1;
    }

    private void assureCapacity() {
        if (count == array.length) {
            // Grow by 1.5x (standard ArrayList behavior)
            int newCapacity = array.length + (array.length >> 1);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public void clear() {
        count = 0; // We don't delete the array, just reset the pointer
    }

    @Override
    public void display() {
        System.out.print("ArrayList: [");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + (i == count - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}