package Servlet;

import Utils.Database;
import Paper.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Lawrence on 5/1/16.
 *
 */
@WebServlet(name = "JudgeAnswer", value = "/judgeAnswer")
public class JudgeAnswer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("email") == null) response.sendRedirect("login.jsp");
        int paperId = Integer.parseInt(request.getParameter("paperid"));
        String path = request.getSession().getServletContext().getRealPath("/excel");
        Database database = Database.getInstance();
        String paperName = database.getPaperInfo(paperId, "papername");
        String paperFileName = database.getPaperInfo(paperId, "filename");
        Paper paper = new Paper(paperName, path, paperFileName);
        ArrayList<Question> questions = paper.getQuestions();
        int score = 0;
        for(int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            if(question.judgeAnswer(Integer.parseInt(request.getParameter((i+1) + "")))) score += 5;
        }
        database.setScore(paperId, (String)session.getAttribute("email"), score);
        response.sendRedirect("home.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
