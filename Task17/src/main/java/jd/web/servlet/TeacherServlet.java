package jd.web.servlet;

import jd.web.entity.Teacher;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Teacher> teacherEntities = new GetAllEntitties<>();
        List<Teacher> teachers = teacherEntities.listEntities(Teacher.class);
        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("teacher.jsp").forward(req, resp);
    }
}
