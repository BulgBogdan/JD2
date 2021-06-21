package jd.tomcat.servlet;

import jd.tomcat.entity.Student;
import jd.tomcat.realization.Realization;
import jd.tomcat.service.Impl.StudentDAOImpl;
import jd.tomcat.service.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Realization realization = new Realization();
        StudentDAO studentDAO = new StudentDAOImpl();

        List<Student> students = studentDAO.getAll(Student.class);
        if (students.isEmpty()) {
            realization.createStudents(20);
        }
        students = studentDAO.getAll(Student.class);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html><head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>");
        writer.write("<body>");
        writer.write("<h2 class='styleFirst'>Students</h2>");
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>Id</th>");
        writer.write("<th>Student FirstName</th>");
        writer.write("<th>Student LastName</th>");
        writer.write("</tr>");

        for (int i = 0; i < students.size(); i++) {
            writer.write("<tr>");
            writer.write("<td>" + students.get(i).getId() + "</td>");
            writer.write("<td>" + students.get(i).getFirstName() + "</td>");
            writer.write("<td>" + students.get(i).getLastName() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

        writer.write("<p><a href='index.jsp'>Home</a></p>");
        writer.write("</body>\n" +
                "</html>");

    }
}
