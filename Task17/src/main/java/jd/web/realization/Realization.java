package jd.web.realization;

import jd.web.entity.*;
import jd.web.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Realization {

    private EntityManager entityManager;

    private Set<Student> students = new HashSet<>();
    private Set<Teacher> teachers = new HashSet<>();

    private void addAdmin() {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Administrator administrator = Administrator.builder().name("Admin").build();
            entityManager.persist(administrator);
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    private void addStudentsTeachersCourses(int count) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Administrator admin = entityManager.find(Administrator.class, 1);

            for (int i = 0; i < count; i++) {
                Student student = Student.builder()
                        .firstName("first_name " + i)
                        .lastName("last_name " + i)
                        .build();
                //add student
                entityManager.persist(student);
                students.add(student);

                Course course = null;
                Teacher teacher = null;

                if (i <= count / 5) {
                    teacher = Teacher.builder()
                            .teacherName("Teacher " + i)
                            .admin(admin)
                            .build();
                    // add teacher
                    entityManager.persist(teacher);
                    teachers.add(teacher);

                    course = Course.builder()
                            .name("Course " + i)
                            .admin(admin)
                            .students(students)
                            .teachers(teachers)
                            .build();
                    // add course
                    entityManager.persist(course);
                }
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    private void addTaskResult(int count) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            List<Course> courseList = entityManager.createQuery("from Course").getResultList();
            List<Student> studentList = entityManager.createQuery("from Student").getResultList();
            List<Teacher> teacherList = entityManager.createQuery("from Teacher").getResultList();
            for (int i = 0; i < count; i++) {
                Course course = courseList.get((int) (Math.random() * courseList.size()));
                Student student = studentList.get((int) (Math.random() * studentList.size()));
                Teacher teacher = teacherList.get((int) (Math.random() * teacherList.size()));
                Task task = Task.builder()
                        .name("Task " + i)
                        .course(course)
                        .student(student)
                        .build();
                //add task
                entityManager.persist(task);

                Result result = Result.builder()
                        .mark(10)
                        .review("Review")
                        .student(student)
                        .teacher(teacher)
                        .task(task)
                        .build();
                //add result
                entityManager.persist(result);
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }

    }

    public void addValuesDB(int count) {
        addAdmin();
        addStudentsTeachersCourses(count);
        addTaskResult(count);
    }

}
