package jd.web.servlet;

import jd.web.realization.Realization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/put")
public class PutServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Realization realization = new Realization();
        realization.addValuesDB(20);
        HttpSession session = req.getSession();
        String timeSession = "0";
        session.setAttribute("timeSession", timeSession);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
