package jd.tomcat.realization;

import jd.tomcat.entity.Student;
import jd.tomcat.entity.Teacher;

import java.util.List;

public class StudentRealization {

    private static String getRandomName() {
        String[] names = {"Ivan", "Fedor", "Alex", "Boris", "Semen", "Vasya", "Kolya"};
        int randomName = (int) (Math.random() * 7);
        return names[randomName];
    }

    private static String getRandomSurName() {
        String[] names = {"Ivanov", "Fedorov", "Alexandrov", "Borisov", "Semenov", "Vasiliev", "Nikolaev"};
        int randomSurName = (int) (Math.random() * 7);
        return names[randomSurName];
    }

    public static Student getStudent(List<Teacher> teachers) {
        int getTeacher = (int) (Math.random() * teachers.size());
        return Student.builder()
                .firstName(getRandomName())
                .lastName(getRandomSurName())
                .teacher(teachers.get(getTeacher)).build();
    }
}
