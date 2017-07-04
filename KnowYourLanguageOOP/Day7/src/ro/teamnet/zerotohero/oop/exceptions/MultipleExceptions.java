package ro.teamnet.zerotohero.oop.exceptions;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class MultipleExceptions {
    public int method() {
        try {
            int a[] = new int[3];
            a[0] = 0; a[1] = 1; a[2] = 2;
            int b = 0;
            return a[3]/b;
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException found");
        } catch (ArrayIndexOutOfBoundsException abe) {
            System.out.println("ArrayIndexOutOfBoundsException found");
        } finally {
            return 0;
        }
    }

    public static void main(String[] args) {
        MultipleExceptions m = new MultipleExceptions();
        m.method();
    }
}
