package Person_Address.implement;

import Person_Address.Address;
import Person_Address.connector.ConnectorCreator;
import Person_Address.dao.AddressDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressDAOImpl implements AddressDAO {

    private Connection connection = null;
    private Statement statement = null;

    @Override
    public void save(Address address) {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("INSERT INTO People.Address" +
                            "(street, house) VALUES ('%s','%s');",
                    address.getStreet(),
                    address.getHouse());
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    private void blockFinallyClose(Connection connection, Statement statement) {
    }

    @Override
    public Address get(Serializable id) {
        Address address = null;
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Address where id = " + id + ";";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                address = new Address(
                        rs.getInt("id"),
                        rs.getString("street"),
                        rs.getInt("house")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(rs)) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            blockFinallyClose(connection, statement);
        }
        return address;
    }

    @Override
    public void update(Address address) {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("UPDATE People.Address SET " +
                            "street = '%s', " +
                            "house = '%d' " +
                            "WHERE id='%d'",
                    address.getStreet(),
                    address.getHouse(),
                    address.getId());
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    @Override
    public int delete(Serializable id) {
        int value = 0;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("DELETE FROM People.Address WHERE id=%d", id);
            if (statement.execute(sql)) {
                value = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
        return value;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Address";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Address address = Address.builder()
                        .id(rs.getInt("id"))
                        .street(rs.getString("street"))
                        .house(rs.getInt("house"))
                        .build();
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(rs)) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            blockFinallyClose(connection, statement);
        }
        return addresses;
    }
}