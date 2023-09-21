package lambda_expression;

public class Lambda {
    static String printThing(Printable thing){
       return thing.print("!");
    }
    public static void main(String[] args) {
        // object is redundant since lambda expression creates it
        Cat myCat = new Cat();

        // the lambda expression automatically creates the instance
        // and provides implementation of the method as expressed
        printThing((suffix) -> "meow" + suffix);

        // saving implementation of a method (lambda expression)
        Printable lambdaPrintable = (suffix) -> "meow" + suffix;
        // passing the variable as lambda expression
        printThing(lambdaPrintable);

        // storing and printing the return value
        String text = printThing(lambdaPrintable);
        System.out.println(text);
    }
}
