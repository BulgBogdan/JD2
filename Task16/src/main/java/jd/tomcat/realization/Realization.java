package jd.tomcat.realization;

import jd.tomcat.entity.Student;
import jd.tomcat.entity.Task;
import jd.tomcat.entity.Teacher;
import jd.tomcat.service.Impl.StudentDAOImpl;
import jd.tomcat.service.Impl.TaskDAOImpl;
import jd.tomcat.service.Impl.TeacherDAOImpl;
import jd.tomcat.service.StudentDAO;
import jd.tomcat.service.TaskDAO;
import jd.tomcat.service.TeacherDAO;

import java.util.List;

public class Realization {

    private StudentDAO studentDAO = new StudentDAOImpl();
    private TeacherDAO teacherDAO = new TeacherDAOImpl();
    private TaskDAO taskDAO = new TaskDAOImpl();

    public void createTeachers(int count) {
        for (int i = 0; i < count; i++) {
            Teacher teacher = TeacherRealization.getTeacher();
            teacherDAO.create(teacher);
        }
    }

    public void createStudents(int count) {
        List<Teacher> teachers = teacherDAO.getAll(Teacher.class);
        if (teachers.isEmpty()) {
            createTeachers(count);
        }
        for (int i = 0; i < count; i++) {
            Student student = StudentRealization.getStudent(teachers);
            studentDAO.create(student);
        }
    }

    public void createTasks(int count) {
        List<Student> students = studentDAO.getAll(Student.class);
        if (students.isEmpty()) {
            createStudents(count);
        }
        for (int i = 0; i < count; i++) {
            Task task = TaskRealization.getTask(students);
            taskDAO.create(task);
        }
    }

}
