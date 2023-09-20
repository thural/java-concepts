package bitwise_condition;

public class BitwiseSample {
    boolean returnTrue() {
        System.out.println("return true called");
        return true;
    }

    boolean returnFalse() {
        System.out.println("return false called");
        return false;
    }

    public static void main(String[] args) {
        BitwiseSample obj = new BitwiseSample();

        // bitwise comparison won't stop at first false value
        // thus, both methods will be called
        if (obj.returnFalse() & obj.returnTrue()) {
            System.out.println("condition is true");
        } else System.out.println("condition is false");

    }
}
