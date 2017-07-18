package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * TODO Write javadoc
 */
@MultipartConfig
public class ImportFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1: Obtain the username from the request instance
        String user = request.getParameter("user");

        // Obtain the File object from the request instance
        Part file = request.getPart("uploadFile");

        // read the lines from CSV file and print the values
        // TODO 2: Replace T with Person
        List<Person> personsFromFile = readLines(file);

        // Set the response type
        response.setContentType("text/html");

        // TODO 6: Print a nice message to the response so the user will be notified of the result
        // TIP: The final text printed on the response should be something like this: "Hello <username>! You successfully imported 4 people. "
        response.getWriter().write("Hello " + user + "! You successfully imported 4 people.");

    }

    /**
     * TODO write javadoc
     * @param file
     * @return
     */
    private List<Person> readLines(Part file) {
        List<Person> persons = new ArrayList<>();
        //String line = "";
//        Stream stream;

        // TODO 3: Replace with try-with-resources
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            //////////////////////////////////////////////////
            Stream<String> stream = bufferedReader.lines();
//            Stream<String> lines = bufferedReader::lines;
            persons = stream.map( s -> s.split(","))
                            .map((String[] values) -> new Person(values[0], values[1],
                                 Long.valueOf(values[2]), Boolean.valueOf(values[3]))).collect(toList());

//            while((line = bufferedReader.readLine()) != null) {
//                String[] values = line.split(",");
//                Person p = new Person();
//                p.first_name = values[0];
//                p.last_name = values[1];
//                p.age = Integer.parseInt(values[2]);
//                p.married = Boolean.valueOf(values[3]);
//                persons.add(p);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO 4: Iterate through the lines of the reader using java streams.
        // TIP: Use map to get the current line
        // TIP: Use split() method for each line (check API documentation)
        // TIP: For Long and Boolean fields you should use valueOf() method
        // TIP: Use Collectors to return a List


        // after implementing the list, let's print it. It will print nicely if you have overridden the toString() method ;)
        persons.forEach(System.out :: println);

//        TODO 5: Sort the persons list by their age field
        // TIP: use lambda expression (only one line of code is needed to complete this step)
//        persons.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.age.compareTo(p2.age);
//            }
//        });

        Collections.sort(persons, (Person p1, Person p2) -> p1.age.compareTo(p2.age));

        // let's print again to check if it's sorted
        persons.forEach(System.out :: println);

        return persons;
    }

    private class T {
    }
}
