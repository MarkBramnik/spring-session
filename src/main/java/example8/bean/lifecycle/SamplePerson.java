package example8.bean.lifecycle;


import javax.annotation.PostConstruct;

public class SamplePerson {
    private String name;
    private int age;

    public SamplePerson() {
        System.out.println("In constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("In post-construct");
    }


    @PostConstruct
    private void anotherPostConstruct() {
        System.out.println("In private post-construct");
    }


    public void oldFashionInitMethod() {
        System.out.println("Inside the init method");
    }


    public void setName(String name) {
        System.out.println("Setting the name : " + name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("Setting the age: " + age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
