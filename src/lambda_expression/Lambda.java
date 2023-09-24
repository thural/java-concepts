package lambda_expression;

public class Lambda {
    static String printThing(Printable thing){
       return thing.print("!");
    }
    public static void main(String[] args) {
        // object is redundant since lambda expression creates it
        Cat myCat = new Cat();

        // the lambda expression automatically implements an anonymous
        // class, implements the method as expressed, then provides
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
    }
}