package exceptions;
// create a custom exception
public class AgeVerifyException extends Exception {
    AgeVerifyException(String msg){
        super(msg);
    }
}
