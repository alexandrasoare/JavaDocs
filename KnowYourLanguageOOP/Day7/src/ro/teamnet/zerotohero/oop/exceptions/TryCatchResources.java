package ro.teamnet.zerotohero.oop.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class TryCatchResources {
    public String method() {
        String path = "file.in";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (Exception e) {
            System.out.println("Exceptie : Nu exista path-ul");
        } finally {
            System.out.println("Finally ...");
        }
        return path;
    }

    public static void main(String[] args) {
        TryCatchResources res = new TryCatchResources();
        res.method();
    }
}
