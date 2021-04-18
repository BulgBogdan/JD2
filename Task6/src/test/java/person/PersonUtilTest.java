package person;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonUtilTest {

    @Test
    public void getRandomName() {
        String[] names = {"Ivan", "Fedor", "Alex", "Boris", "Semen", "Vasya", "Kolya"};
        int randomName = (int) (Math.random() * 7);
        assertNotNull(names[randomName]);
        assertTrue((randomName <= names.length) && (randomName >= 0));
    }

    @Test
    public void getRandomSurName() {
        String[] names = {"Ivanov", "Fedorov", "Alexandrov", "Borisov", "Semenov", "Vasiliev", "Nikolaev"};
        int randomSurName = (int) (Math.random() * 7);
        assertTrue((randomSurName <= names.length) && (randomSurName >= 0));
        assertNotNull(names[randomSurName]);
    }

    @Test
    public void personList() {
        List<Person> personsWithAge = PersonUtil.personList(15, 30);
        for (Person person : personsWithAge) {
            assertTrue((person.getAge() >= 15) && (person.getAge() <= 30));
            assertNotNull(person);
        }
    }
}