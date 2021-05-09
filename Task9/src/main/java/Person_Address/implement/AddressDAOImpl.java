package Person_Address.implement;

import Person_Address.Address;
import Person_Address.connector.ConnectorCreator;
import Person_Address.dao.AddressDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressDAOImpl implements AddressDAO {

    private Connection connection = null;

    @Override
    public void save(Address address) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Address (street, house) VALUES (?,?);";
            List<String> parameters = new ArrayList<>();
            parameters.add(address.getStreet());
            parameters.add(String.valueOf(address.getHouse()));
            if (PreparedStatementUtil.executePreparedStatement(sql, connection, parameters)) {
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
    }

    @Override
    public Address get(Serializable id) throws SQLException {
        Address address = null;
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM People.Address where id = " + id + ";";
            address = ResultSetUtil.executeResultSet(sql, connection, new Address());
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "UPDATE Address SET street = ?, house = ? WHERE id=?";
            List<String> parameters = new ArrayList<>();
            parameters.add(address.getStreet());
            parameters.add(String.valueOf(address.getHouse()));
            parameters.add(String.valueOf(address.getId()));

            if (PreparedStatementUtil.executePreparedStatement(sql, connection, parameters)) {
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        int value = 0;
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "DELETE FROM Address WHERE id=?";
            List<String> parameters = new ArrayList<>();
            parameters.add(String.valueOf(id));
            if (PreparedStatementUtil.executePreparedStatement(sql, connection, parameters)) {
                connection.commit();
                value = 1;
            }
        } catch (SQLException e) {
            connection.rollback();
            value = 0;
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
        return value;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try {
            connection = ConnectorCreator.getConnection();
            String sql = "SELECT * FROM Address";
            addresses = ResultSetUtil.executeResultSetList(sql, connection, new Address());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(connection))
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return addresses;
    }

    @Override
    public void correctPerson(Address address) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "{call correctAddress(?, ?, ?)}";
            List<String> parameters = new ArrayList<>();
            parameters.add(String.valueOf(address.getId()));
            parameters.add(address.getStreet());
            parameters.add(String.valueOf(address.getHouse()));
            if (PreparedStatementUtil.executePreparedStatement(sql, connection, parameters)) {
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
    }
}