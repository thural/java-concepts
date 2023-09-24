package stream_sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        // get a sorted list by age
        List <Employee> sortedList = list.stream()
                .filter(employee -> employee.age >= 25)
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());

        // check if all elements match the given condition
        List <Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        boolean matchResult = numbers.stream()
                .allMatch(number -> number<7);
        System.out.println(matchResult);

        // check if at least one element meets the required condition
        boolean hasOlderThan50 = list.stream()
                .anyMatch(employee -> employee.age > 50);
        System.out.println("has an employee older than 50: " + hasOlderThan50);

    }
}
