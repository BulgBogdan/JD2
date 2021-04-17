package person;

import person.implement.PersonDBImpl;
import person.implement.PersonFileImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class Runner {
    public static void main(String[] args) {

        PersonFileImpl filePerson = new PersonFileImpl();

        PersonDBImpl personDB = new PersonDBImpl();

        // group 100 persons with age
        List<Person> persons = PersonUtil.personList(15, 30);

        // persons with less age
        List<Person> personsWithAge = persons.stream().filter(x -> (x.getAge() <= 21)).collect(Collectors.toList());

        // print persons
        personsWithAge.forEach(System.out::println);

        // sort by surname and name
        List<Person> sortPersons = personsWithAge.stream()
                .sorted(Comparator.comparing(Person::getSurName).thenComparing(Person::getName))
                .collect(Collectors.toList());

        // delete dublicate
        List<Person> deleteDouble = sortPersons.stream().distinct().collect(Collectors.toList());

        // write file
        filePerson.createPerson(deleteDouble);

        // read file
        List<Person> readPersons = filePerson.getAllPerson();

        List<String> listNames = readPersons.stream()
                .map(person -> person.getSurName() + " - " + person.getName())
                .collect(Collectors.toList());

        // print surname and name
        listNames.forEach(System.out::println);

        // add to DB
        personDB.createPerson(deleteDouble);

        System.out.println("---------- show Names and Surnames from DB ----------");

        // get all persons from DB
        List<String> listNamesFromDB = personDB.getAllPerson().stream()
                .map(person -> person.getSurName() + " - " + person.getName())
                .collect(Collectors.toList());

        listNamesFromDB.forEach(System.out::println);
    }
}