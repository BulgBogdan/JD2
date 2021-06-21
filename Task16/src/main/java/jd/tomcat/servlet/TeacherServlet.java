package jd.tomcat.servlet;

import jd.tomcat.entity.Teacher;
import jd.tomcat.realization.Realization;
import jd.tomcat.service.Impl.TeacherDAOImpl;
import jd.tomcat.service.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/teachers"})
public class TeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Realization realization = new Realization();
        TeacherDAO teacherDAO = new TeacherDAOImpl();

        List<Teacher> teachers = teacherDAO.getAll(Teacher.class);
        if (teachers.isEmpty()) {
            realization.createTeachers(3);
        }
        teachers = teacherDAO.getAll(Teacher.class);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html><head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>");
        writer.write("<body>");
        writer.write("<h2 class='styleFirst'>Teachers</h2>");
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>Id</th>");
        writer.write("<th>Teacher Name</th>");
        writer.write("</tr>");

        for (int i = 0; i < teachers.size(); i++) {
            writer.write("<tr>");
            writer.write("<td>" + teachers.get(i).getId() + "</td>");
            writer.write("<td>" + teachers.get(i).getTeacherName() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

        writer.write("<p><a href='index.jsp'>Home</a></p>");
        writer.write("</body>\n" +
                "</html>");
    }
}
