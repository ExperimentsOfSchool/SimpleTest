package Servlet;

import Utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lawrence on 5/1/16.
 *
 */
@WebServlet(name = "signupAccess", value = "/signupAccess")
public class signupAccess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int result = -1;
        out.println(password);
        Database database = Database.getInstance();
        if(database.checkEmailAddress(email) == 0) {
            if(password != null && !password.equals("")) {
                result = database.registry(email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                response.sendRedirect("home.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
