package jd.courses.realization;

import jd.courses.entity.*;
import jd.courses.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Realization {

    private EntityManager entityManager;

    Administrator administrator = Administrator.builder().name("Admin").build();
    Student student = Student.builder().firstName("first_name").lastName("last_name").build();
    Teacher teacher = Teacher.builder().teacherName("Teacher").admin(administrator).build();
    Set<Student> students = new HashSet<>();
    Set<Teacher> teachers = new HashSet<>();

    {
        students.add(student);
        teachers.add(teacher);
    }

    Course course = Course.builder().name("Java").admin(administrator).students(students).teachers(teachers).build();
    Task task = Task.builder().name("Task").course(course).student(student).build();
    Result result = Result.builder().mark(10).review("Review").student(student).teacher(teacher).task(task).build();

    public void putValuesInDB() {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(administrator);
            entityManager.persist(course);
            entityManager.persist(task);
            entityManager.persist(teacher);
            entityManager.persist(student);
            entityManager.persist(result);
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

}
