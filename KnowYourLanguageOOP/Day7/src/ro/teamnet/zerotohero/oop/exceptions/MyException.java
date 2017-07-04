package ro.teamnet.zerotohero.oop.exceptions;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class MyException extends Exception {
    public MyException(){}

    public MyException(String s) {
        System.out.println(s);
    }
}
