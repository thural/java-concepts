package playground;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    int instanceVar = 1;

    public static void main(String[] args) {
//        Comparator<Person> compareObject = new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.name.compareTo(p2.name);
//            }
//        };
//
//        List<Person> personList = List.of(
//                new Person(32,"male","John"),
//                new Person(18,"female","Susan")
//        );
//
//        Collections.sort(personList, compareObject);
//        System.out.println(personList.get(0));

        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str4 = new String("test");
//
//        if(str1==str2) System.out.println("strings are equal");

//        int a = 1;
//
//        System.out.println(a++);
//        System.out.println(a);
        boolean a = str1 == str2;
        boolean b = str1 == str3;
        boolean c = str3 == str4;
        boolean d = str1.equals(str2);
        boolean e = str1.equals(str3);
        boolean f = str3.equals(str4);

        if(f) {
            System.out.println("true");
        } else System.out.println("false");

    }
}
