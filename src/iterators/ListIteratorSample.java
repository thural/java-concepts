package iterators;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorSample {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating an object of ArrayList class
        ArrayList al = new ArrayList();

        // Iterating over Arraylist object
        for (int i = 0; i < 10; i++)

            // Adding elements to the Arraylist object
            al.add(i);

        // Print and display all elements inside object
        // created above
        System.out.println(al);

        // At beginning ltr(cursor) will point to
        // index just before the first element in al
        ListIterator ltr = al.listIterator();

        // Checking the next element availability
        while (ltr.hasNext()) {
            //  Moving cursor to next element
            int i = (Integer)ltr.next();

            // Getting even elements one by one
            System.out.print(i + " ");

            // Changing even numbers to odd and
            // adding modified number again in
            // iterator
            if (i % 2 == 0) {
                // Change to odd
                i++;
                // Set method to change value
                ltr.set(i);
                // To add
                ltr.add(i);
            }
        }

        // Print and display statements
        System.out.println();
        System.out.println(al);
    }
}
