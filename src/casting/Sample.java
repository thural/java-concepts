package casting;

public class Sample {
    public static void doAnimalStuff(Animal animal) {
        if (animal instanceof Cat) {
            Cat myCat = (Cat) animal;
            myCat.catOnlyMethod();
            myCat.makeSound();
        } else System.out.println("a Cat instance is expected");
    }

    public static void main(String[] args) {
        // upcasting
        Cat cat = new Cat();
        Animal animal = (Animal) cat;
        animal.makeSound();

        // down-casting
        Cat cat1 = (Cat) animal;
        cat1.makeSound();
        cat1.catOnlyMethod();
        doAnimalStuff(animal);
    }
}