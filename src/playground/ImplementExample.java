package playground;

public class ImplementExample implements A, B{
    @Override
    public void sayHello(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ImplementExample i = new ImplementExample();
        i.sayHello();
    }

    @Override
    public void doStuff() {
        System.out.println("walking");
    }
}
