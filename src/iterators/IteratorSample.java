package iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorSample {

    public static void main(String[] args) {
        // create and fill a list
        List<String> cities = new LinkedList<>();
        cities.add("G-1");
        cities.add("G-2");
        cities.add("G-3");

        // create an iterator
        Iterator<String> citiesIterator = cities.iterator();

        // check if the collection has next element
        boolean hasNextElem = citiesIterator.hasNext();
        System.out.println(hasNextElem);

        // get the next element
        String elem = citiesIterator.next();
        System.out.println(elem);

        // remove current element
        citiesIterator.remove();

        // get the next element after removal
        elem = citiesIterator.next();
        System.out.println(elem);
    }
}
