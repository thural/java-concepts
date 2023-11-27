package optional_class;

public class Cat {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat(){}

    public Cat(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    void makesSound(){
        System.out.println("meows");
    }
}
