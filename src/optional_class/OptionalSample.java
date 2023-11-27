package optional_class;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalSample {
    static Optional<Cat> getCat(){
        Cat cat = new Cat("Orange", 7);

        // create an optional using of() method if an object will always be present
        Optional<Cat> notEmptyOptional = Optional.of(cat);

        // create an empty optional
        Optional <Cat> emptyOptional  = Optional.empty();

        // create a nullable optional
        Optional <Cat> nulllableOptional = Optional.ofNullable(cat);

        // return an optional which may not contain an object
        return nulllableOptional;
    }

    public static void main(String[] args) {
        Optional <Cat> optionalCat = getCat();

        // check if Optional contains an element with ifPresent()
        if(optionalCat.isPresent()){
            // get object out of the Optional using get()
            Cat myCat = optionalCat.get();

            myCat.makesSound();
        } else {
            System.out.println("there is no cat inside the optional");
        }

        // orElse(), which returns passed element if no object is present
        optionalCat.orElse(new Cat()).makesSound();

        // orElseGet() method to supply an object using a lambda if no object is present
        Supplier<? extends Cat> supplier = null;
        optionalCat.orElseGet(supplier);

        // get a value from Optional using chained methods
        optionalCat.map(Cat::getAge)
                .orElse(0);

        // get the object or else throw an exception if the object is not present
        optionalCat.orElseThrow();
    }
}