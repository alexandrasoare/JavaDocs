package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexandra.Soare on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();

        if(username.equals("admin") && password.equals("admin")) {
            resp.getWriter().write("Welcome back " + username);
            String sessionId = req.getSession().getId();
            resp.getWriter().write("\nSession id = " + sessionId);
        } else {
            //resp.getWriter().write("Error");
            httpSession.setAttribute("session", httpSession);
            httpSession.setAttribute("user", username);
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/views/loginFail.jsp");
            requestDispatcher.forward(req, resp);

        }
    }
}
