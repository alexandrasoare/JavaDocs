package ro.teamnet.zerotohero.oop.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class TryFinally {
    public String method() throws Exception{
        String path = "C:\\Users\\alexandra.soare\\IdeaProjects\\Day7\\src\\ro\\teamnet\\zerotohero\\oop\\exceptions\\filePath.in";
        BufferedReader br = new BufferedReader(new FileReader(path));
        System.out.println("OK");
        try {
            return br.readLine();
        } finally {
            if (br != null)
                br.close();
            System.out.println("Close br");
        }

    }

    public static void main(String[] args) throws Exception {
        TryFinally tf = new TryFinally();
        tf.method();
    }
}
