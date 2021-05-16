package hibernateConnect;

import hibernateConnect.dao.AddressDAO;
import hibernateConnect.dao.PersonDAO;
import hibernateConnect.dao.implement.AddressDAOImpl;
import hibernateConnect.dao.implement.PersonDAOImpl;
import hibernateConnect.entity.Address;
import hibernateConnect.entity.Person;
import hibernateConnect.util.AddressUtil;
import hibernateConnect.util.PersonUtil;

import java.util.List;

public class Realization {

    PersonDAO personDAO = new PersonDAOImpl();
    AddressDAO addressDAO = new AddressDAOImpl();

    void createPersonAndAddress(int count) {
        for (int i = 0; i < count; i++) {
            addressDAO.create(AddressUtil.getAddress());
            List<Address> addresses = addressDAO.getAll();
            personDAO.create(PersonUtil.getPerson(addresses));
        }
    }

    void correctPersonAndAddress(int lastPositions, int changeValue) {
        Person person = null;
        Address address = null;
        List<Person> persons = personDAO.getAll();
        List<Address> addresses = addressDAO.getAll();

        // correct last 2 persons
        for (int i = persons.size() - lastPositions; i < persons.size(); i++) {
            person = persons.get(i);
            personDAO.update(Person.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .surname(person.getSurname())
                    .age(person.getAge() + changeValue)
                    .address(person.getAddress())
                    .build());
        }
        // correct last 2 addresses
        for (int i = addresses.size() - lastPositions; i < addresses.size(); i++) {
            address = addresses.get(i);
            addressDAO.update(Address.builder()
                    .id(address.getId())
                    .street(address.getStreet())
                    .house(address.getHouse() + changeValue)
                    .build());
        }
    }

    void deletePersonsAndAddress(int id) {
        Address address = addressDAO.get(id);

        addressDAO.delete(address);
    }

    void correctAddress(int id, String street, int house) {
        Address address = Address.builder().id(id).street(street).house(house).build();
        addressDAO.update(address);
    }
}
