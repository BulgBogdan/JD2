package person;

import org.junit.Test;
import person.connector.ConnectorCreator;
import person.implement.PersonDBImpl;
import person.implement.PersonFileImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class RunnerTest {

    @Test
    public void getObjectDB() {
        PersonDBImpl personDB = new PersonDBImpl();
        assertNotNull(personDB);
    }

    @Test
    public void getObjectFile() {
        PersonFileImpl filePerson = new PersonFileImpl();
        assertNotNull(filePerson);
    }

    @Test
    public void getConnectionDB() {
        try {
            Connection connection = ConnectorCreator.getConnection();
            assertNotNull(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPersonWithAge() {
        List<Person> personsWithAge = PersonUtil.personList(15, 30)
                .stream().filter(x -> (x.getAge() <= 21)).collect(Collectors.toList());
        for (Person person : personsWithAge) {
            assertTrue(person.getAge() <= 21);
        }
    }

    @Test
    public void deleteDoublicate() {
        List<Person> personsWithAge = PersonUtil.personList(15, 30).stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < personsWithAge.size(); i++) {
            int count = 0;
            for (int j = 0; j < personsWithAge.size(); j++) {
                if (personsWithAge.get(i).equals(personsWithAge.get(j))) {
                    count++;
                }
            }
            assertEquals(1, count);
        }
    }
}