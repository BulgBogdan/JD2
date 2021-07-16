package jd.web.servlet;

import jd.web.entity.Result;
import jd.web.realization.CookieGet;
import jd.web.realization.EntitiesGetAll;
import jd.web.realization.SessionGet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntitiesGetAll<Result> teacherEntities = new EntitiesGetAll<>();
        List<Result> results = teacherEntities.listEntities(Result.class);
        // get cookie
        req.setAttribute("cookieValue", CookieGet.getCookie(req.getCookies(), "nameCookie"));
        // session time
        HttpSession session = req.getSession();
        session.setAttribute("timeSession", SessionGet.getSession(session, "timeSession"));
        req.setAttribute("results", results);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
