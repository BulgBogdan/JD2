package people.util;

import people.Address;
import people.Person;
import people.PersonAddress;

import java.util.List;

public class PersonAddressUtil {

    private static int getAddress(List<Address> addresses) {
        int[] values = new int[addresses.size()];
        int value = 0;
        for (Address address : addresses) {
            values[value] = address.getId();
            value++;
        }
        return values[(int) (Math.random() * values.length)];
    }

    private static int getPerson(List<Person> persons) {
        int[] values = new int[persons.size()];
        int count = 0;
        for (Person person : persons) {
            values[count] = person.getId();
            count++;
        }
        int value = 0;
        if (values.length > 1) {
            value = values[values.length - 1];
        } else {
            value = values[value];
        }
        return value;
    }

    public static PersonAddress getPersonAddress(Person person, Address address) {

        return PersonAddress.builder()
                .person_id(person.getId())
                .address_id(address.getId())
                .build();
    }
}
