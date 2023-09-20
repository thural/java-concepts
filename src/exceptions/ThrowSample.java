package exceptions;

import java.util.Scanner;

public class ThrowSample {
    static int age;
    static Integer minimumAge = 18;

    static void enterAge() throws AgeVerifyException {
        // get age from user input
        Scanner sc = new Scanner(System.in);
        System.out.println("enter age");
        age = sc.nextInt();

        // throw an exception if age is smaller than the minimum
        if(age < minimumAge){
            throw new AgeVerifyException("access denied: entered age is under " + minimumAge);
        }

        System.out.println("welcome");
    }

    public static void main (String[] args){
        // try and catch the custom exception
        try {
            ThrowSample.enterAge();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
