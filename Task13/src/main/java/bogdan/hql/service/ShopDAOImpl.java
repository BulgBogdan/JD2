package bogdan.hql.service;

import bogdan.hql.entity.Shop;
import bogdan.hql.util.HibernateUtil;
import org.eclipse.persistence.exceptions.EclipseLinkException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopDAOImpl implements ShopDAO {

    private EntityManager entityManager;

    @Override
    public void create(Shop shop) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(shop);
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
    public Shop get(Serializable id) {
        Shop shop = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            shop = entityManager.find(Shop.class, id);
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return shop;
    }

    @Override
    public void update(Shop shop) {
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(shop);
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
    public boolean delete(Shop shop) {
        boolean deleted = false;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(shop));
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
    public List<Shop> getAll() {
        List<Shop> shops = new ArrayList<>();
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            shops = entityManager.createQuery("from Shop s").getResultList();
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return shops;
    }
}
