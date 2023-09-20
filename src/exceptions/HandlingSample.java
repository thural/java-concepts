package exceptions;

public class HandlingSample {
    static int a = 5;
    static int b = 0;
    static int[] array = {1, 2, 3};

    public static void main(String[] args) {
        try {
            // always the first exception is caught
            int d = array[3];
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("in class: " + e.getClass());
            System.out.print("error: " + e.getMessage());
        } catch (Exception e) {
            // usage of Exception is always recommended
            System.out.println(e.getMessage());
        } finally {
            // finally block always runs
            System.out.println("program is running");
        }
    }
}
