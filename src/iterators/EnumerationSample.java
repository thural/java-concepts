package iterators;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationSample {
    public static void main(String[] args) {
        // creating a vector object
        Vector vector = new Vector();

        // add elements to the vector
        for (int i = 0; i < 10; i++) vector.addElement(i);

        // create an enumeration
        Enumeration enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            // moving cursor to next element
            int i = (Integer) enumeration.nextElement();
            // print the elements in object
            System.out.print(i + " ");
        }
    }
}

/*
 enumeration can be applied to Vector and HashTable collections
 and has 2 methods:

 boolean hasMoreElements()
 Object nextElement()
*/