package jd.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = LocalDateTime.now().toString();
        Cookie myCookie = new Cookie("nameCookie", date);
        myCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(myCookie);
        // session time
        HttpSession session = req.getSession();
        String startTime = (String) session.getAttribute("timeSession");
        String nowTime = String.valueOf(LocalTime.now().getSecond() + Integer.valueOf(startTime));
        session.setAttribute("timeSession", nowTime);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
