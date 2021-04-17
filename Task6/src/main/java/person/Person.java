package person;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Person implements Serializable {

    private int id;
    private String name;
    private String surName;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private Date birthday;
    private Timestamp timeCreate;
    private Timestamp timeLunch;
    private String letter;

    public Person() {
    }

    public Person(int id, String name, String surName, int age, double salary, String passport,
                  String address, Date birthday, Timestamp timeCreate, Timestamp timeLunch, String letter) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.birthday = birthday;
        this.timeCreate = timeCreate;
        this.timeLunch = timeLunch;
        this.letter = letter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Timestamp getTimeLunch() {
        return timeLunch;
    }

    public void setTimeLunch(Timestamp timeLunch) {
        this.timeLunch = timeLunch;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surName, person.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", timeCreate=" + timeCreate +
                ", timeLunch=" + timeLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}