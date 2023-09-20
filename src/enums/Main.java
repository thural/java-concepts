package enums;

public class Main {

    // how to declare enum variable
    static Sizes displaySize = Sizes.HD;

    public static void main(String[] args) {
        // simple enum
        System.out.println(Sizes.HD);

        // as a declared variable
        System.out.println("Display size is: " + displaySize);

        // with toString override
        System.out.println("HD size is: " + DisplaySizes.HD);

        // with switch
        System.out.println("FullHD size is: " + DisplaySizesSwitch.FullHD.getSize());

        // with constructor
        System.out.println("HD size is: " + DisplaySizesConstructors.HD);
    }
}