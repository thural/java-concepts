package iterators;

import java.util.Enumeration;
import java.util.Vector;

public class EnumeratorSample {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating a vector object
        Vector v = new Vector();

        // Iterating over vector object
        for (int i = 0; i < 10; i++)
            v.addElement(i);

        // Printing elements in vector object
        System.out.println(v);

        // At beginning e(cursor) will point to
        // index just before the first element in v
        Enumeration e = v.elements();

        // Checking the next element availability where
        // condition holds true till there is a single
        // element
        // remaining in the List
        while (e.hasMoreElements()) {
            // Moving cursor to next element
            int i = (Integer)e.nextElement();

            // Print above elements in object
            System.out.print(i + " ");
        }
    }
}
