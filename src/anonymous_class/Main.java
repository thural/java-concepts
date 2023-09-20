package anonymous_class;

public class Main {

    public static void main(String[] args) {
        // create and use an anonymous class extending a normal class
        NormalClass normalObject = new NormalClass(){
            // override a method
            @Override
            void makeSound(){
                System.out.println("makes beep sound");
            }
        };
        normalObject.sayHello();
        normalObject.makeSound();

        // create and use an anonymous class extending an abstract class
        AbstractClass abstractObject = new AbstractClass() {
            @Override
            void sayHello() {
                System.out.println("hello from abstract");
            }
        };
        abstractObject.sayHello();

        // create and use an anonymous class implementing an interface
        InterfaceClass interfaceObject = new InterfaceClass() {
            @Override
            public void sayHello() {
                System.out.println("hello from interface");
            }
        };
        interfaceObject.sayHello();

    }
}
