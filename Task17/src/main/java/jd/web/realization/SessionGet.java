package jd.web.realization;

import javax.servlet.http.HttpSession;
import java.time.LocalTime;

public class SessionGet {

    public static String getSession(HttpSession session, String nameAttribute) {
        String startTime = (String) session.getAttribute(nameAttribute);
        return String.valueOf(LocalTime.now().getSecond() + Integer.valueOf(startTime));
    }
}
