package custom_arraylist;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArray = new MyArrayList<>(4);
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(8);
        myArray.add(12);
        myArray.add(16);

        System.out.println(myArray);

        System.out.println("element at index 3 is: " + myArray.indexOf(3));
        System.out.println("array size: " + myArray.size());
        System.out.println("removed element: " + myArray.remove(1));
        System.out.println("array size after 1 removal: " + myArray.size());

        System.out.println(myArray);
    }
}