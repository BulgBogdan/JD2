package Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        FileWriter writer = new FileWriter("Task4\\fileText.txt");
        for (Person person : notDoublePerson) {
            String name = person.getName();
            String surName = person.getSurName();
            String age = String.valueOf(person.getAge());
            writer.write("surName = " + surName +
                    ", name = " + name +
                    ", age = " + age + "\n");
        }
        writer.close();

        System.out.println("----------------Print from txt------------------");

        // read file
        BufferedReader br = new BufferedReader(new FileReader("Task4\\fileText.txt"));
        String text;
        List<String> listNames = new ArrayList<>();
        while ((text = br.readLine()) != null) {
            String[] line = text.split(",");
            String names = line[0] + "," + line[1];
            listNames.add(names);
        }
        br.close();

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
        writer.close();

        System.out.println("--------------Print from properties--------------");

        // read properties
        for (int i = 1; i <= notDoublePerson.size(); i++) {
            ResourceBundle bundle = ResourceBundle.getBundle("file", Locale.ENGLISH);
            System.out.println(bundle.getString("surName" + i) + "-" + bundle.getString("name" + i));
        }
    }
}