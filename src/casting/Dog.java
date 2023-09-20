package casting;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("barks");
    }

    public void dogOnlyMethod() {
        System.out.println("dog method");
    }
}