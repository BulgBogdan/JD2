package people;

import people.dao.AddressDAO;
import people.dao.PersonAddressDAO;
import people.dao.PersonDAO;
import people.implement.AddressDAOImpl;
import people.implement.PersonAddressDAOImpl;
import people.implement.PersonDAOImpl;
import people.util.AddressUtil;
import people.util.PersonAddressUtil;
import people.util.PersonUtil;

import java.sql.SQLException;
import java.util.List;

public class Realization {

    PersonDAO personDAO = new PersonDAOImpl();
    AddressDAO addressDAO = new AddressDAOImpl();
    PersonAddressDAO personAddressDAO = new PersonAddressDAOImpl();

    void createPersonAndAddress(int count) throws SQLException {
        for (int i = 0; i < count; i++) {
            personDAO.save(PersonUtil.getPerson());
            addressDAO.save(AddressUtil.getAddress());
        }
        List<Person> persons = personDAO.getAll();
        List<Address> addresses = addressDAO.getAll();
        for (Person person : persons) {
            for (Address address : addresses) {
                personAddressDAO.save(PersonAddressUtil.getPersonAddress(person, address));
            }
        }
    }

    void correctPersonAndAddress(int lastPositions, int changeValue) throws SQLException {
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
                    .surName(person.getSurname())
                    .age(person.getAge() + changeValue)
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

    void deletePersonsAndAddress(int id) throws SQLException {
        personDAO.delete(id);
        addressDAO.delete(id);
    }
}