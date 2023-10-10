package finalizer;

public class FinalizerSample {
    //The main purpose of a finalizer is releasing resources used by objects
    // before they’re removed from the memory

    // Overriding the finalize method which is inherited from Object class
    @Override
    protected void finalize() throws Throwable {
        try {
            // release the resources in try block
            System.out.println("inside demo's finalize()");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Calling finalize method of the Object class");
            // calling finalize() of Object class (the superclass of every class)
            super.finalize();
        }
    }

    public static void main(String[] args) throws Throwable {
        // creating demo's object
        FinalizerSample obj = new FinalizerSample();

        // unreferencing the object by assigning the null value
        obj = null;

        // finalize method is called when garbage collector runs
        // calling the garbage collector manually
        System.gc();
    }

}