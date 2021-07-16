package jd.web.servlet;

import jd.web.entity.Course;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Course> teacherEntities = new GetAllEntitties<>();
        List<Course> courses = teacherEntities.listEntities(Course.class);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("course.jsp").forward(req, resp);
    }
}
