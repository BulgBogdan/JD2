package jd.web.servlet;

import jd.web.entity.Task;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Task> teacherEntities = new GetAllEntitties<>();
        List<Task> tasks = teacherEntities.listEntities(Task.class);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("task.jsp").forward(req, resp);
    }
}
