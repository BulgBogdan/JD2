package Person_Address;

import Person_Address.dao.AddressDAO;
import Person_Address.dao.PersonDAO;
import Person_Address.implement.AddressDAOImpl;
import Person_Address.implement.PersonDAOImpl;
import Person_Address.util.AddressUtil;
import Person_Address.util.PersonUtil;

import java.sql.SQLException;
import java.util.List;

public class Realization {

    PersonDAO personDAO = new PersonDAOImpl();
    AddressDAO addressDAO = new AddressDAOImpl();

    void createPersonAndAddress(int count) throws SQLException {
        for (int i = 0; i < count; i++) {
            addressDAO.save(AddressUtil.getAddress());
            List<Address> addresses = addressDAO.getAll();
            personDAO.save(PersonUtil.getPerson(addresses));
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
                    .surname(person.getSurname())
                    .age(person.getAge() + changeValue)
                    .id_address(person.getId_address())
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

    void correctAddress(int id, String street, int house) throws SQLException {
        Address address = Address.builder().id(id).street(street).house(house).build();
        addressDAO.correctPerson(address);
    }
}