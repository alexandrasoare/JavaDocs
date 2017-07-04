package ro.teamnet.zerotohero.oop.exceptions;

import java.io.IOException;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class ExceptionClass extends MyException {

    public void method() {
        try {
            throw new MyException("ceva");
        } catch (MyException e) {
            //e.printStackTrace();
            System.out.println("---> Exceptie prinsa");
        }
    }

    public static void main(String[] args) {
        ExceptionClass e = new ExceptionClass();
        e.method();
    }
}
