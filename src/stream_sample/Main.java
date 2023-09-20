package stream_sample;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("John", 25, 2500.0, Type.DEVELOPER));
        list.add(new Employee("Tommy", 40, 5000.0, Type.BOSS));
        list.add(new Employee("Arnold", 19, 250.0, Type.DEVELOPER));
        list.add(new Employee("Kyle", 35, 1000.0, Type.MANAGER));
        list.add(new Employee("Susan", 55, 3500.0, Type.MANAGER));
        list.add(new Employee("Chloe", 45, 4500.0, Type.BOSS));

        // get name of the developer with the highest salary
        list.stream()
                .filter(employee -> employee.type == Type.DEVELOPER)
                .max(Comparator.comparingDouble(employee -> employee.salary))
                .ifPresent(max -> System.out.println(max.name));

        // get name of the employee which gets the least salary among age group 25 and up
        list.stream()
                .filter(employee -> employee.age >= 25)
                .min(Comparator.comparing(employee -> employee.salary))
                .ifPresent(min -> System.out.println(min.name));

    }
}
