package exercise3;

/**
 * Created by Alexandra.Soare on 7/7/2017.
 */
public class StudentAllPropertiesD extends Student {

    public StudentAllPropertiesD(String firstName, String lastName) {
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

        if(this.firstName != this.firstName && this.lastName != this.lastName)
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
