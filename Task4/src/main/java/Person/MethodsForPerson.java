package Person;

import java.util.ArrayList;
import java.util.List;

public class MethodsForPerson {

    private static String getRandomNameOrSurName() {
        return String.copyValueOf(new char[]{(char) ('a' + Math.random() * ('z' - 'a' + 1))});
    }

    static List<Person> personList(int minAge, int maxAge) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            int age = (int) (Math.random() * (maxAge + 1)) + minAge;
            Person person = new Person(getRandomNameOrSurName(), getRandomNameOrSurName(), age);
            personList.add(person);
        }
        return personList;
    }

    static List<Person> personListWithAge(int age, List<Person> personsList) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personsList) {
            if (person.getAge() < age) {
                persons.add(person);
            }
        }
        return persons;
    }

    static List<Person> withoutDuble(List<Person> personsList) {
        for (int i = 0; i < personsList.size(); i++) {
            for (int j = 0; j < personsList.size(); j++) {
                if (i == j) {

                } else if (personsList.get(j).equals(personsList.get(i))) {
                    personsList.remove(j);
                }
            }
        }
        return personsList;
    }
}
