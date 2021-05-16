package hibernateConnect;

import hibernateConnect.util.HibernateUtil;

public class Runner {
    public static void main(String[] args) {
        Realization realization = new Realization();

        //create
        realization.createPersonAndAddress(5);

        //correct
        realization.correctPersonAndAddress(2, 2);

        //delete
        realization.deletePersonsAndAddress(1);

        //correct with procedure
        realization.correctAddress(2, "Pobediteley", 125);

        HibernateUtil.close();
    }
}
