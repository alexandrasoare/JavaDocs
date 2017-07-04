package ro.teamnet.zerotohero.oop.exceptions;

import java.io.IOException;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class ExceptionPropagation {

    public void method1() {
        try{
            method2();
        }catch(MyException e){
            System.out.println("Exception!!!");
        }
    }

    public void method2() throws MyException {
        method3();
    }

    public void method3() throws MyException {
        throw new MyException();
    }

    public static void main(String[] args) throws MyException {
        ExceptionPropagation ep = new ExceptionPropagation();
        ep.method3();
    }
}
