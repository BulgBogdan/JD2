package people;

import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private String surname;
    private int age;
    private int id_address;

    public Person(int id, String name, String surname, int age, int id_address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id_address = id_address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getId_address() {
        return id_address;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private int id;
        private String name;
        private String surname;
        private int age;
        private int id_address;

        public PersonBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder surName(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder id_address(int id_address) {
            this.id_address = id_address;
            return this;
        }

        public Person build() {
            return new Person(id, name, surname, age, id_address);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", id_address=" + id_address +
                '}';
    }
}
