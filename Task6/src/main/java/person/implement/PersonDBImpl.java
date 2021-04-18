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

public class PersonDBImpl implements PersonService {

    @Override
    public void createPerson(List<Person> persons) {
        try {
            Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement();
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
            ConnectorCreator.closeConnection();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> result = new ArrayList<>();
        try {
            Connection connection = ConnectorCreator.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM `People`.`Person`";
            ResultSet rs = statement.executeQuery(sql);
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
        }
        return result;
    }

}