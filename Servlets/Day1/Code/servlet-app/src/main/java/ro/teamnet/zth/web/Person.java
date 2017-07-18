package ro.teamnet.zth.web;

/**
 * Created by Alexandra.Soare on 7/18/2017.
 */
public class Person {
    public String first_name;
    public String last_name;
    public Long age;
    public Boolean married;

    public Person(String first_name, String last_name, Long age, Boolean married) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.married = married;
    }

    @Override
    public String toString() {
        return this.first_name + ", " + this.last_name + ", " + this.age + ", " + this.married;
    }
}
