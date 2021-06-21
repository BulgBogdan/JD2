package jd.tomcat.servlet;

import jd.tomcat.entity.Task;
import jd.tomcat.realization.Realization;
import jd.tomcat.service.Impl.TaskDAOImpl;
import jd.tomcat.service.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TaskServlet", urlPatterns = {"/tasks"})
public class TaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Realization realization = new Realization();
        TaskDAO taskDAO = new TaskDAOImpl();

        List<Task> tasks = taskDAO.getAll(Task.class);
        if (tasks.isEmpty()) {
            realization.createTasks(50);
        }
        tasks = taskDAO.getAll(Task.class);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html><head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>");
        writer.write("<body>");
        writer.write("<h2 class='styleFirst'>Tasks</h2>");
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>Number</th>");
        writer.write("<th>Task name</th>");
        writer.write("</tr>");

        int count = 1;
        for (int i = 0; i < tasks.size(); i++) {
            writer.write("<tr>");
            writer.write("<td>" + count + "</td>");
            writer.write("<td>" + tasks.get(i).getTaskName() + "</td>");
            writer.write("</tr>");
            count++;
        }
        writer.write("</table>");

        writer.write("<p><a href='index.jsp'>Home</a></p>");
        writer.write("</body>\n" +
                "</html>");


    }
}
