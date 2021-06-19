package jd.tomcat.repository;

import jd.tomcat.entity.Student;
import jd.tomcat.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.Objects;

public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Override
    public Student getByID(int id) {
        Student student = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            student = entityManager.find(Student.class, id);
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return student;
    }
}
