package person.implement;

import person.Person;
import person.service.PersonService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileImpl implements PersonService {

    final String PATH = "Task6\\src\\main\\resources\\Task6.dat";

    @Override
    public void createPerson(List<Person> persons) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            persons = (ArrayList<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
