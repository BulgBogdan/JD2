package jd.tomcat.realization;

import jd.tomcat.entity.Teacher;

public class TeacherRealization {

    private static String getRandomName() {
        String[] names = {
                "Ivan", "Stepan", "Alex",
                "Evgen", "Oleg", "Petya"
        };
        int randomName = (int) (Math.random() * 6);
        return names[randomName];
    }

    public static Teacher getTeacher() {
        return Teacher.builder()
                .teacherName(getRandomName()).build();
    }
}
