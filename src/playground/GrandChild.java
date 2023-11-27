package playground;

public class GrandChild extends Child{
    void sayHello(){
        super.sayHello();
        System.out.println("Hello from GrandChild");
    }

    public static void main(String[] args) {
        GrandChild o = new GrandChild();
        o.sayHello();
    }
}
