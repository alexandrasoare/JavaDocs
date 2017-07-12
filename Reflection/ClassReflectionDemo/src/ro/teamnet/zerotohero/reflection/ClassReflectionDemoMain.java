package ro.teamnet.zerotohero.reflection;

import ro.teamnet.zerotohero.reflection.demoobjects.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) {
        //TODO get the class for a String object, and print it
		String s = "cuvant";
        System.out.println(s.getClass());

        //TODO get the class of an Enum, and print it
        System.out.println(names.Ada.getClass());

        //TODO get the class of a collection, and print it
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a.getClass());

        //TODO get the class of a primitive type, and print it
        System.out.println(int.class);

        //TODO get and print the class for a field of primitive type
        MyClass myClass = new MyClass();
        try {
            System.out.println(myClass.getClass().getDeclaredField("x").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //TODO get and print the class for a primitive type, using the wrapper class
        Integer integer = new Integer(3);
        System.out.println(integer.TYPE);

        //TODO get the class for a specified class name
        MyClass m = new MyClass();
        System.out.println(m.getClass());

        //TODO get the superclass of a class, and print it
        AnotherClass anotherClass = new AnotherClass();
        System.out.println(anotherClass.getClass().getSuperclass());

        //TODO get the superclass of the superclass above, and print it
        AnotherClass2 anotherClass2 = new AnotherClass2();
        System.out.println(anotherClass2.getClass().getSuperclass().getSuperclass());

        //TODO get and print the declared classes within some other class
        MyClass my = new MyClass();
        Class[] arr = my.getClass().getDeclaredClasses();

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        //TODO print the number of constructors of a class
        AnotherClass another = new AnotherClass();
        System.out.println(another.getClass().getDeclaredConstructors().length);

        //TODO get and invoke a public constructor of a class
        AnotherClass an = new AnotherClass();

        try {
           Object x = an.getClass().newInstance();
            System.out.println(x.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        //TODO get and print the class of one private field 
        MyClass newClass = new MyClass();
        try {
            System.out.println(newClass.getClass().getDeclaredField("privateParam").getType());
        } catch (NoSuchFieldException e) {
        e.printStackTrace();
    }

        //TODO set and print the value of one private field for an object
        try {

            Field f = newClass.getClass().getDeclaredField("privateParam");
            f.setAccessible(true);
            f.set(newClass, 12);
            System.out.println(f.get(newClass));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //TODO get and print only the public fields class
        Field[] field = newClass.getClass().getFields();
        for (int i = 0; i < field.length; i++) {
            System.out.println(field[i].getType());
        }

        //TODO get and invoke one public method of a class
        try {
            Method method = newClass.getClass().getMethod("getX");
            System.out.println(method.invoke(newClass));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //TODO get and invoke one inherited method of a class
       AnotherClass ac = new AnotherClass();
        try {
            Method mth = ac.getClass().getSuperclass().getMethod("getX");
            System.out.println(mth.invoke(ac));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //TODO invoke a method of a class the classic way for 100 times, and print the timestamp (System.currentTimeMillis())
		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
        long before = System.currentTimeMillis();
        MyClass myc = new MyClass();
		for(int i = 0; i < 1000; i++)
            myc.getX();
		long after = System.currentTimeMillis();
        System.out.println("Classic : " + (after-before));

        before = System.currentTimeMillis();
        MyClass myc2 = new MyClass();
        for(int i = 0; i < 1000; i++) {
            try {
                Method method = newClass.getClass().getMethod("getX");
                method.invoke(newClass);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        after = System.currentTimeMillis();
        System.out.println("Reflection : " + (after-before));
    }
}
