package lambda_expression;

public class Cat implements Printable {
    @Override
    public String print(String suffix) {
        return "meow" + suffix;
    }
}
