package bogdan.hql.service;

import bogdan.hql.entity.Seller;
import bogdan.hql.util.HibernateUtil;
import org.eclipse.persistence.exceptions.EclipseLinkException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SellerDAOImpl implements SellerDAO {

    private EntityManager entityManager;

    @Override
    public void create(Seller seller) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(seller);
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public Seller get(Serializable id) {
        Seller seller = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            seller = entityManager.find(Seller.class, id);
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return seller;
    }

    @Override
    public void update(Seller seller) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(seller);
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(Seller seller) {
        boolean deleted = false;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(seller));
            entityManager.getTransaction().commit();
            deleted = true;
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return deleted;
    }

    @Override
    public List<Seller> getAll() {
        List<Seller> sellers = new ArrayList<>();
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            sellers = entityManager.createQuery("from Seller s").getResultList();
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return sellers;
    }
}
