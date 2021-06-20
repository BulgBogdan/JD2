package jd.tomcat.realization;

import jd.tomcat.entity.Student;
import jd.tomcat.entity.Task;

import java.util.List;

public class TaskRealization {

    private static String getRandomNameTask() {
        String[] tasks = {
                "Java", "Phyton", "C++",
                "JS", "C#", "Ruby"
        };
        int randomTask = (int) (Math.random() * 6);
        return tasks[randomTask];
    }

    public static Task getTask(List<Student> students) {
        int getStudent = (int) (Math.random() * students.size());
        return Task.builder()
                .taskName(getRandomNameTask())
                .student(students.get(getStudent))
                .build();
    }
}
