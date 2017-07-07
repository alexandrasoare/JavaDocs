package exercise3;

/**
 * Created by Alexandra.Soare on 7/7/2017.
 */
public class StudentFirstNameC extends Student {

    public StudentFirstNameC(String firstName, String lastName) {
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
        int hash = 31 * this.getFirstName().hashCode();
        hash = hash * 31 + this.getLastName().hashCode();
        return hash;
    }
}
