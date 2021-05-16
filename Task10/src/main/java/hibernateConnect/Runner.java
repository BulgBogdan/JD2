package hibernateConnect;

import hibernateConnect.dao.AddressDAO;
import hibernateConnect.dao.PersonDAO;
import hibernateConnect.dao.implement.AddressDAOImpl;
import hibernateConnect.dao.implement.PersonDAOImpl;
import hibernateConnect.entity.Address;
import hibernateConnect.entity.Person;

public class Runner {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAOImpl();
        AddressDAO addressDAO = new AddressDAOImpl();
        Address address = Address.builder()
                .street("Masherova")
                .house(20).build();
        addressDAO.create(address);
        Person person = Person.builder()
                .name("Ivan")
                .surname("Ivanov")
                .age(20)
                .address(addressDAO.get(2))
                .build();
        personDAO.create(person);
    }
}
