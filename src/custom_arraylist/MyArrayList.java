package custom_arraylist;

import java.util.Arrays;

// create a dynamic array using Generic Types
public class MyArrayList<T> {
    int count = 0;
    T[] array;

    MyArrayList(int size) {
        array = newArray(size);
    }

    int size() {
        return array.length;
    }

    T get(int index) {
        return array[index];
    }

    int indexOf(T elem) {
        for (int i = 0; i < array.length; i++) {
            // if found, return index of the element
            if (array[i] == elem) {
                return i;
            }
        }
        // otherwise return -1
        return -1;
    }

    void add(T elem) {
        assureCapacity();
        array[count] = elem;
        count++;
    }

    @SafeVarargs
    static <T> T[] newArray(int length, T... array) {
        return Arrays.copyOf(array, length);
    }

    T remove(int index) {
        // create a new array to store the rest of the elements
        T[] copyArray = newArray(array.length - 1);
        // store the target element
        T removedElement = array[index];
        // apply offset after removing an element
        int indexOffset = 0;
        // copy all elements to new array except the target element
        for (int i = 0; i < array.length; i++) {

            // skip copying the target element
            if (i == index) {
                indexOffset--;
                continue;
            }

            copyArray[i + indexOffset] = array[i];
        }
        // replace the array with processed array
        array = copyArray;
        // return removed element
        return removedElement;
    }

    void assureCapacity() {
        // if array capacity is exceeded
        if (count + 1 == array.length) {
            T[] copyArray = newArray(array.length + array.length / 2);
            for (int i = 0; i < array.length; i++) {
                copyArray[i] = array[i];
            }
            array = copyArray;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
