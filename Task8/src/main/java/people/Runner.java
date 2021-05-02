package people;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Realization realization = new Realization();

        //create
        realization.createPersonAndAddress(5);

        //correct
        realization.correctPersonAndAddress(2, 2);

        //delete
        realization.deletePersonsAndAddress(1);
    }
}