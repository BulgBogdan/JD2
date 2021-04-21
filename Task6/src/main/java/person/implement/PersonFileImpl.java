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
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeOutputStream(fos, oos);
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(PATH);
            ois = new ObjectInputStream(fis);
            persons = (ArrayList<Person>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeInputStream(fis, ois);
        }
        return persons;
    }

    private void closeOutputStream(FileOutputStream fos, ObjectOutputStream oos) {
        try {
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeInputStream(FileInputStream fis, ObjectInputStream ois) {
        try {
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
