package Person_Address.implement;

import Person_Address.Person;
import Person_Address.connector.ConnectorCreator;
import Person_Address.dao.PersonDAO;
import Person_Address.util.PreparedStatementUtil;
import Person_Address.util.ResultSetUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDAOImpl implements PersonDAO {

    private Connection connection = null;

    @Override
    public void save(Person person) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Person (name, sur_name, age, address_id) VALUES (?, ?, ?, ?);";
            List<String> parameters = new ArrayList<>();
            parameters.add(person.getName());
            parameters.add(person.getSurname());
            parameters.add(String.valueOf(person.getAge()));
            parameters.add(String.valueOf(person.getId_address()));

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
    public Person get(Serializable id) throws SQLException {
        Person person = null;
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM Person where id = " + id + ";";
            person = ResultSetUtil.executeResultSet(sql, connection, new Person());
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection))
                connection.close();
        }
        return person;
    }

    @Override
    public void update(Person person) throws SQLException {
        try {
            connection = ConnectorCreator.getConnection();
            connection.setAutoCommit(false);
            String sql = "UPDATE Person SET name = ?, sur_name = ?, age = ?, address_id = ? WHERE id=?";
            List<String> parameters = new ArrayList<>();
            parameters.add(person.getName());
            parameters.add(person.getSurname());
            parameters.add(String.valueOf(person.getAge()));
            parameters.add(String.valueOf(person.getId_address()));
            parameters.add(String.valueOf(person.getId()));

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
            String sql = "DELETE FROM Person WHERE id=?";
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
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try {
            connection = ConnectorCreator.getConnection();
            String sql = "SELECT * FROM Person";
            persons = ResultSetUtil.executeResultSetList(sql, connection, new Person());
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
        return persons;
    }
}