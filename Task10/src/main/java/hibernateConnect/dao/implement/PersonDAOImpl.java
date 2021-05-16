package hibernateConnect.dao.implement;

import hibernateConnect.dao.PersonDAO;
import hibernateConnect.entity.Person;
import hibernateConnect.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);

    private EntityManager entityManager;

    @Override
    public void create(Person person) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            logger.info("Person successfully added. Person: " + person);
        } catch (HibernateException ex) {
            logger.error("Error Person not added", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public Person get(Serializable id) {
        Person person = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            person = entityManager.find(Person.class, id);
            entityManager.getTransaction().commit();
            logger.info("Person successfully found. Person: " + person);
        } catch (HibernateException ex) {
            logger.error("Error Person not found", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return person;
    }

    @Override
    public void update(Person person) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(person);
            entityManager.getTransaction().commit();
            logger.info("Person successfully updated. Person: " + person);
        } catch (HibernateException ex) {
            logger.error("Error Person not updated", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(Person person) {
        boolean deleted = false;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(person));
            entityManager.getTransaction().commit();
            deleted = true;
            logger.info("Person successfully deleted. Person: " + person);
        } catch (HibernateException ex) {
            logger.error("Error Person not deleted", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return deleted;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            persons = entityManager.createQuery("from Person").getResultList();
            entityManager.getTransaction().commit();
            for (Person person : persons) {
                logger.info("Person successfully found. Person: " + person);
            }
        } catch (HibernateException ex) {
            logger.error("Error Person not found", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return persons;
    }
}
