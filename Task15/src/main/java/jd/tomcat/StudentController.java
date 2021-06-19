package jd.tomcat;

import jd.tomcat.entity.Student;
import jd.tomcat.repository.StudentDAO;
import jd.tomcat.repository.StudentDAOImpl;
import jd.tomcat.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentController", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        Student student = studentDAO.getByID(1);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<p>Student firstName: " + student.getFirstName() + "</p>");
        writer.write("<p>Student lastName: " + student.getLastName() + "</p>");
        writer.write("<p><a href='#' onclick='history.back();'>Back</a></p>");
        HibernateUtil.closeEntityManagerFactory();
    }
}
