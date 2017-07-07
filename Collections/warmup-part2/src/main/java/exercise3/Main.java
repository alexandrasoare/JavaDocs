package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Alexandra.Soare on 7/7/2017.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<StudentFirstNameA, BigDecimal> hashMapA = new HashMap<StudentFirstNameA, BigDecimal>();
        HashMap<StudentFirstNameB, BigDecimal> hashMapB = new HashMap<StudentFirstNameB, BigDecimal>();
        HashMap<StudentFirstNameC, BigDecimal> hashMapC = new HashMap<StudentFirstNameC, BigDecimal>();
        HashMap<StudentAllPropertiesD, BigDecimal> hashMapD = new HashMap<StudentAllPropertiesD, BigDecimal>();

        System.out.println("A");
        hashMapA.put(new StudentFirstNameA("Ion", "Popescu"), new BigDecimal(21));
        hashMapA.put(new StudentFirstNameA("Ion", "K"), new BigDecimal(22));
        System.out.println(hashMapA);

        System.out.println();
        System.out.println("B");
        hashMapB.put(new StudentFirstNameB("Ion", "Popescu"), new BigDecimal(21));
        hashMapB.put(new StudentFirstNameB("Ion", "K"), new BigDecimal(22));
        System.out.println(hashMapB);

        System.out.println();
        System.out.println("C");
        hashMapC.put(new StudentFirstNameC("Ion", "Popescu"), new BigDecimal(21));
        hashMapC.put(new StudentFirstNameC("Ion", "K"), new BigDecimal(22));
        System.out.println(hashMapC);

        System.out.println();
        System.out.println("D");
        hashMapD.put(new StudentAllPropertiesD("Ion", "Popescu"), new BigDecimal(21));
        hashMapD.put(new StudentAllPropertiesD("Ion", "K"), new BigDecimal(22));
        System.out.println(hashMapD);
    }
}
