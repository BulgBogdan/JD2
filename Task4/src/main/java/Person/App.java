package Person;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        // group 100 persons with age
        List<Person> persons = MethodsForPerson.personList(15, 30);

        // persons with less age
        List<Person> personsWithAge = persons.stream().filter(x -> (x.getAge() <= 21)).collect(Collectors.toList());

        // print persons
        for (Person person : personsWithAge) {
            System.out.println(person.toString());
        }

        // sort by surname and name
        List<Person> sortPersons = personsWithAge.stream()
                .sorted(Comparator.comparing(Person::getSurName).thenComparing(Person::getName))
                .collect(Collectors.toList());

        // delete dublicate
        List<Person> notDoublePerson = MethodsForPerson.withoutDuble(sortPersons);

        // write file
        FileOutputStream fos = new FileOutputStream("Task4-fileText.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(notDoublePerson);
        oos.close();


        System.out.println("----------------Print from file------------------");

        // read file
        List<Person> readedPersons = new ArrayList<>();
        FileInputStream fis = new FileInputStream("Task4-fileText.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            readedPersons = (ArrayList<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<String> listNames = readedPersons.stream().map(person -> person.getSurName() + " - " + person.getName()).collect(Collectors.toList());

        // print surname and name
        listNames.forEach(System.out::println);

        // write properties file
        int valueForWriter = 1;
        Properties properties = new Properties();
        for (Person person : notDoublePerson) {
            String name = person.getName();
            String surName = person.getSurName();
            properties.setProperty("surName" + valueForWriter, surName);
            properties.setProperty("name" + valueForWriter, name);
            MethodsForPerson.saveProperties(properties);
            valueForWriter++;
        }

        System.out.println("--------------Print from properties--------------");

        // read properties
        for (int i = 1; i <= notDoublePerson.size(); i++) {
            ResourceBundle bundle = ResourceBundle.getBundle("file", Locale.ENGLISH);
            System.out.println(bundle.getString("surName" + i) + "-" + bundle.getString("name" + i));
        }
    }
}