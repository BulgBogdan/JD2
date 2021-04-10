package Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        System.out.println("----------------------------------");

        // sort by surname and name
        List<Person> sortPersons = personsWithAge.stream()
                .sorted(Comparator.comparing(Person::getSurName).thenComparing(Person::getName))
                .collect(Collectors.toList());

        // delete dublicate
        List<Person> notDoublePerson = sortPersons.stream().distinct().collect(Collectors.toList());

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
    }
}