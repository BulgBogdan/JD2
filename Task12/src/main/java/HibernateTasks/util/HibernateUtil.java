package HibernateTasks.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.configure();
        return config.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
