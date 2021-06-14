package jd.courses;

import jd.courses.realization.Realization;
import jd.courses.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Realization realization = new Realization();

        realization.putValuesInDB();

        HibernateUtil.closeEntityManagerFactory();
    }
}
