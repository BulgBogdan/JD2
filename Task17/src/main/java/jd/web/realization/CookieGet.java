package jd.web.realization;

import javax.servlet.http.Cookie;

public class CookieGet {

    public static String getCookie(Cookie[] cookies, String cookieName) {
        String cookieValue = "";
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                break;
            }
        }
        return cookieValue;
    }
}
