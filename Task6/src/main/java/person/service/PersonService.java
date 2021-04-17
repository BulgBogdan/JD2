package person.service;

import person.Person;

import java.util.List;

public interface PersonService {

    void createPerson(List<Person> persons);

    List<Person> getAllPerson();
}