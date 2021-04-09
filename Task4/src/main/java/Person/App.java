package Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        List<Person> persons = MethodsForPerson.personList(15, 30);
        List<Person> personsWithAge = MethodsForPerson.personListWithAge(21, persons);
        //
        for (Person person : personsWithAge) {
            System.out.println(person.toString());
        }

        // sort
        Comparator<Person> byName = new PersonNameComparator();
        Comparator<Person> bySurName = new PersonSurNameComparator();
        Collections.sort(personsWithAge, bySurName);
        Collections.sort(personsWithAge, byName);

//delete dublicate
        List<Person> withoutDublicateListPersons = MethodsForPerson.withoutDuble(personsWithAge);
        System.out.println(withoutDublicateListPersons.size());

        FileWriter writer = new FileWriter("output.txt");
        for (Person person : withoutDublicateListPersons) {
            String name = person.getName();
            String surName = person.getSurName();
            String age = String.valueOf(person.getAge());
            writer.write(name +
                    " " + surName +
                    " " + age + " ");
        }
        writer.close();

        BufferedReader br = new BufferedReader(new FileReader("output.txt"));
        String[] line = br.readLine().split(" ");
        List<String> names = new ArrayList<>();
        List<String> surNames = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if ((i + 1) % 3 == 0) {
            } else if ((i + 1) % 2 == 0) {
                surNames.add(line[i]);
            } else if ((i + 1) % 1 == 0) {
                names.add(line[i]);
            }
        }
        br.close();

        String[] arrName = new String[names.size()];
        String[] arrSurName = new String[surNames.size()];

        for (int i = 0; i < names.size(); i++) {
            arrName[i] = names.get(i);
        }
        for (int i = 0; i < surNames.size(); i++) {
            arrSurName[i] = surNames.get(i);
        }


        List<String> nameAndSurName = new ArrayList<>();
        for (int i = 0; i < arrName.length; i++) {
            nameAndSurName.add(arrName[i] + " " + arrSurName[i]);
        }

        for (String s : nameAndSurName) {
            System.out.println(s);
        }
        System.out.println(names.size());
        System.out.println(surNames.size());

    }
}
