package HibernateSession;

import HibernateSession.realization.Realization;
import HibernateSession.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Realization realization = new Realization();

        //create
        realization.createPersonAndAddress(5);

        //correct
        realization.correctPersonAndAddress(2, 2);

        //delete
        realization.deletePersonsAndAddress(1);

        //correct
        realization.correctAddress(2, "Pobediteley", 125);

        HibernateUtil.closeSessionFactory();
    }
}
