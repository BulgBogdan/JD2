package Person;

import java.util.Comparator;

public class PersonSurNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getSurName().compareTo(b.getSurName());
    }

}
