package playground;

public class Person {
//    Integer age;
//    String gender;
//    String name;
//    Person(Integer age, String gender, String name){
//        this.age = age;
//        this.gender = gender;
//        this.name = name;
//    }
void sayHello(){
    System.out.println("hello from Java");
}

    public static void main(String[] args){

        Person p = new Person(){
            @Override
            void sayHello(){
                System.out.println("hello from Java");
            }
        };

        p.sayHello();
    }

}
