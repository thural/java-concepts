package lambda_expression;

import java.util.function.Predicate;

public class Lambda {
    static String printThing(Printable thing) {
        return thing.print("!");
    }

    public static void main(String[] args) {
        // using object of a Class that implements the interface
        Cat myCat = new Cat();
        printThing(myCat);

        // using an anonymous class that implements the interface
        Printable printableObject = new Printable() {
            @Override
            public String print(String suffix) {
                return "printing..." + suffix;
            }
        };

        String text0 = printThing(printableObject);
        System.out.println(text0);

        // the lambda expression automatically implements an anonymous
        // class, overrides the method as expressed, then provides
        // an instance of that class where its expressed
        String text1 = printThing((suffix) -> "meow" + suffix);
        System.out.println(text1);

        // saving an instance ef the implementation
        Printable lambdaPrintable = (suffix) -> "meow" + suffix;
        // passing the instance of the implementation as variable
        String text2 = printThing(lambdaPrintable);
        System.out.println(text2);

        // storing and printing the return value
        String text3 = lambdaPrintable.print("!!!");
        System.out.println(text3);

        // using internal Predicate functional interface
        Predicate checkForNull = (o) -> o != null;
        Object object = null;
        boolean testResult = checkForNull.test(object);
        System.out.println(testResult);
    }
}