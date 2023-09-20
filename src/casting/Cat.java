package casting;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("meows");
    }

    public void catOnlyMethod() {
        System.out.println("cat method");
    }
}
