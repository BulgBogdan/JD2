package jd.web.servlet;

import jd.web.entity.Result;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Result> teacherEntities = new GetAllEntitties<>();
        List<Result> results = teacherEntities.listEntities(Result.class);
        req.setAttribute("results", results);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
