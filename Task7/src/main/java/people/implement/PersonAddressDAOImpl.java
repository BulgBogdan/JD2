package people.implement;

import people.PersonAddress;
import people.connector.ConnectorCreator;
import people.dao.PersonAddressDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static people.implement.FinallyUtil.blockFinallyClose;

public class PersonAddressDAOImpl implements PersonAddressDAO {

    private Connection connection = null;
    private Statement statement = null;

    @Override
    public void save(PersonAddress personAddress) {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("INSERT INTO People.Person_Address" +
                            "(person_id, address_id) VALUES ('%s','%s');",
                    personAddress.getPerson_id(),
                    personAddress.getAddress_id());
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    @Override
    public PersonAddress get(Serializable id) throws SQLException {
        PersonAddress personAddress = null;
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Person_Address where id = " + id + ";";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                personAddress = new PersonAddress(
                        rs.getInt("id"),
                        rs.getInt("person_id"),
                        rs.getInt("address_id")
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
        return personAddress;
    }

    @Override
    public void update(PersonAddress personAddress) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("UPDATE People.Person_Address SET " +
                            "person_id = '%d', " +
                            "address_id = '%d' " +
                            "WHERE id='%d'",
                    personAddress.getPerson_id(),
                    personAddress.getAddress_id(),
                    personAddress.getId());
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        int value = 0;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("DELETE FROM People.Person_Address WHERE id=%d", id);
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
    public List<PersonAddress> getAll() {
        List<PersonAddress> personAddresses = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Person_Address";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                PersonAddress personAddress = PersonAddress.builder()
                        .id(rs.getInt("id"))
                        .person_id(rs.getInt("person_id"))
                        .address_id(rs.getInt("address_id"))
                        .build();
                personAddresses.add(personAddress);
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
        return personAddresses;
    }
}
