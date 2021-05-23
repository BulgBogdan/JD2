package HibernateSession.realization;

import HibernateSession.dao.AddressDAO;
import HibernateSession.dao.Impl.AddressDAOImpl;
import HibernateSession.dao.Impl.PersonDAOImpl;
import HibernateSession.dao.PersonDAO;
import HibernateSession.entity.Address;
import HibernateSession.entity.Person;

import java.util.List;
import java.util.Objects;

public class Realization {

    PersonDAO personDAO = new PersonDAOImpl();
    AddressDAO addressDAO = new AddressDAOImpl();

    public void createPersonAndAddress(int count) {
        for (int i = 0; i < count; i++) {
            addressDAO.create(AddressRealization.getAddress());
            List<Address> addresses = addressDAO.getAll(Address.class);
            personDAO.create(PersonRealization.getPerson(addresses));
        }
    }

    public void correctPersonAndAddress(int lastPositions, int changeValue) {
        Person person = null;
        Address address = null;
        List<Person> persons = personDAO.getAll(Person.class);
        List<Address> addresses = addressDAO.getAll(Address.class);

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

    public void deletePersonsAndAddress(int id) {
        if (Objects.nonNull(addressDAO.get(Address.class, id)))
            addressDAO.delete(Address.class, id);
    }

    public void correctAddress(int id, String street, int house) {
        Address address = Address.builder().id(id).street(street).house(house).build();
        addressDAO.update(address);
    }
}
