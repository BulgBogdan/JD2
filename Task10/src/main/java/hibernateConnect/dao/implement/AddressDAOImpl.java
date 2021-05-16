package hibernateConnect.dao.implement;

import hibernateConnect.dao.AddressDAO;
import hibernateConnect.entity.Address;
import hibernateConnect.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressDAOImpl implements AddressDAO {

    private static final Logger logger = Logger.getLogger(AddressDAOImpl.class);

    private EntityManager entityManager;

    @Override
    public void create(Address address) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            logger.info("Address successfully added. Address: " + address);
        } catch (HibernateException ex) {
            logger.error("Error Address not added", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public Address get(Serializable id) {
        Address address = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            address = entityManager.find(Address.class, id);
            entityManager.getTransaction().commit();
            logger.info("Address successfully found. Address: " + address);
        } catch (HibernateException ex) {
            logger.error("Error Address not found", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return address;
    }

    @Override
    public void update(Address address) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(address);
            entityManager.getTransaction().commit();
            logger.info("Address successfully updated. Address: " + address);
        } catch (HibernateException ex) {
            logger.error("Error Address not updated", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(Address address) {
        boolean deleted = false;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(address));
            entityManager.getTransaction().commit();
            deleted = true;
            logger.info("Address successfully deleted. Address: " + address);
        } catch (HibernateException ex) {
            logger.error("Error Address not deleted", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return deleted;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            addresses = entityManager.createQuery("from Address").getResultList();
            entityManager.getTransaction().commit();
            for (Address address : addresses) {
                logger.info("Address successfully found. Address: " + address);
            }
        } catch (HibernateException ex) {
            logger.error("Error Address not found", ex);
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return addresses;
    }
}
