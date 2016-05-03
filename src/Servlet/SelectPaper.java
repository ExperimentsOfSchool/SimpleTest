package Servlet;

import Utils.Database;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Lawrence on 16/5/2.
 */
@WebServlet(name = "SelectPaper", value = "/SelectPaper")
public class SelectPaper extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("email") == null) response.sendRedirect("login.jsp");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int paperid = Integer.parseInt(request.getParameter("paperid"));
        Database database = Database.getInstance();
        session.setAttribute("papername", database.getPaperInfo(paperid, "papername"));
        session.setAttribute("filename", database.getPaperInfo(paperid, "filename"));
        response.sendRedirect("paper.jsp");
    }
}
