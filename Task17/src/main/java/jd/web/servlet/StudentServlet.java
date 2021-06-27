package jd.web.servlet;

import jd.web.entity.Student;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Student> teacherEntities = new GetAllEntitties<>();
        List<Student> students = teacherEntities.listEntities(Student.class);
        req.setAttribute("students", students);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}
