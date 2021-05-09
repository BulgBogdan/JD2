package Person_Address.dao;

import Person_Address.Address;

import java.sql.SQLException;

public interface AddressDAO extends DAO<Address> {
    void correctPerson(Address address) throws SQLException;
}
