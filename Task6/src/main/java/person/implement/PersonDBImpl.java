package person.implement;

import person.Person;
import person.connector.ConnectorCreator;
import person.service.PersonService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDBImpl implements PersonService {

    @Override
    public void createPerson(List<Person> persons) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            for (Person person : persons) {
                String sql = String.format("INSERT INTO `People`.`Person`" +
                                "(name, sur_name, age, salary, passport, address, " +
                                "date_birthday, date_time, time_lunch, letter) " +
                                "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",
                        person.getName(),
                        person.getSurName(),
                        person.getAge(),
                        person.getSalary(),
                        person.getPassport(),
                        person.getAddress(),
                        person.getBirthday(),
                        person.getTimeCreate(),
                        person.getTimeLunch(),
                        person.getLetter());
                statement.executeUpdate(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = ConnectorCreator.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM `People`.`Person`";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sur_name"),
                        rs.getInt("age"),
                        rs.getDouble("salary"),
                        rs.getString("passport"),
                        rs.getString("address"),
                        rs.getDate("date_birthday"),
                        rs.getTimestamp("date_time"),
                        rs.getTimestamp("time_lunch"),
                        rs.getString("letter")
                );
                result.add(person);
            }
            ConnectorCreator.closeConnection();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            blockFinallyClose(connection, statement);
            try {
                if (Objects.nonNull(rs)) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private void blockFinallyClose(Connection connection, Statement statement) {
        try {
            if (Objects.nonNull(connection)) {
                ConnectorCreator.closeConnection();
            }
            if (Objects.nonNull(statement)) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}