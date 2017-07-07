package exercise3;

/**
 * Created by Alexandra.Soare on 7/7/2017.
 */
public class StudentFirstNameA extends Student {

    public StudentFirstNameA(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "[firstName = " + this.firstName + ", lastName = " + this.lastName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(o.getClass() != this.getClass())
            return false;

        Student s = (Student) o;

        if(this.firstName != this.firstName)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * this.getFirstName().hashCode();
    }
}
