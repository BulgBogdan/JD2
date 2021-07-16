package jd.web.servlet;

import jd.web.entity.Administrator;
import jd.web.realization.GetAllEntitties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdministratorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllEntitties<Administrator> adminEntities = new GetAllEntitties<>();
        List<Administrator> admins = adminEntities.listEntities(Administrator.class);
        req.setAttribute("admins", admins);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }
}
