package iterators;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorSample {
    public static void main(String[] args) {
        // creating an object of ArrayList class
        ArrayList arrayList = new ArrayList();

        // adding elements into the Arraylist object
        for (int i = 0; i < 10; i++) arrayList.add(i);

        // create an iterator by calling the method
        ListIterator iterator = arrayList.listIterator();

        // checking the next element availability
        while (iterator.hasNext()) {
            // moving cursor to next element
            int i = (Integer) iterator.next();
            // changing even numbers to odd
            if (i % 2 == 0) {
                i++;
                iterator.set(i);
            }
        }

        System.out.println();
        System.out.println(arrayList);
    }
}

/*
 ListIterator can be applied to any List objects
 and has 9 methods:

 boolean hasNext()
 Object next()
 int nextIndex()

 boolean hasPrevious()
 Object previous()
 int previousIndex()

 void remove()
 void set(Object obj)
 void add(Object obj)
*/