package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Alexandra.Soare on 7/18/2017.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> enumer = req.getHeaderNames();

        while(enumer.hasMoreElements()) {
            String name = enumer.nextElement();
            resp.getWriter().write("Header: " + name + "\n\n");

            Enumeration<String> heads = req.getHeaders(name);

            while (heads.hasMoreElements()) {
                String h = heads.nextElement();
                resp.getWriter().write(h+ "\n");
            }
        }
    }
}
