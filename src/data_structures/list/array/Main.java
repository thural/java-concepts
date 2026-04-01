package data_structures.list.array;

public class Main {
    public static void main(String[] args) {
        ArrayList myArrayList = new ArrayList(4);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(8);
        myArrayList.add(12);
        myArrayList.add(16);

        System.out.println(myArrayList);

        System.out.println("element at index 3 is: " + myArrayList.indexOf(3));
        System.out.println("array size: " + myArrayList.size());
        System.out.println("array size after 1 removal: " + myArrayList.size());

        System.out.println(myArrayList);
    }
}