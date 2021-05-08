package Person_Address.implement;

import Person_Address.Person;
import Person_Address.connector.ConnectorCreator;
import Person_Address.dao.PersonDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Person_Address.implement.FinallyUtil.blockFinallyClose;

public class PersonDAOImpl implements PersonDAO {

    private Connection connection = null;
    private Statement statement = null;

    @Override
    public void save(Person person) {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("INSERT INTO People.Person" +
                            "(name, sur_name, age, address_id) VALUES ('%s','%s','%s','%s');",
                    person.getName(),
                    person.getSurname(),
                    person.getAge(),
                    person.getId_address());
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    @Override
    public Person get(Serializable id) {
        Person person = null;
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Person where id = " + id + ";";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                person = new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sur_name"),
                        rs.getInt("age"),
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
        return person;
    }

    @Override
    public void update(Person person) {
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = String.format("UPDATE People.Person SET " +
                            "name = '%s', " +
                            "sur_name = '%s', " +
                            "age = '%d', " +
                            "address_id = '%d' " +
                            "WHERE id='%d'",
                    person.getName(),
                    person.getSurname(),
                    person.getAge(),
                    person.getId_address(),
                    person.getId());
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
            String sql = String.format("DELETE FROM People.Person WHERE id=%d", id);
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
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM People.Person";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Person person = Person.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("sur_name"))
                        .surname(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .id_address(rs.getInt("address_id"))
                        .build();
                persons.add(person);
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
        return persons;
    }
}