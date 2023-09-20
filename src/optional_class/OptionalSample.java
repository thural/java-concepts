package optional_class;

import java.util.Optional;

public class OptionalSample {
    static Optional<Cat> getCat(){
        Cat cat = new Cat();
        return Optional.ofNullable(cat);
    }

    public static void main(String[] args) {
        Optional <Cat> myCat = getCat();

        // check if Optional contains an element with ifPresent()
        if(myCat.isPresent()){
            // get object out of the Optional using get()
            myCat.get().makesSound();
        } else {
            System.out.println("there is no cat inside the optional");
        }

        // using orElse(), which returns passed element if not present
        myCat.orElse(new Cat()).makesSound();

    }
}
