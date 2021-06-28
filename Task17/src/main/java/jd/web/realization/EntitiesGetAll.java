package jd.web.realization;

import jd.web.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EntitiesGetAll<T> {

    private EntityManager entityManager;

    public List<T> listEntities(Class<T> type) {
        List<T> list = new ArrayList();
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from " + type.getName()).getResultList();
            entityManager.getTransaction().commit();
        } catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return list;
    }
}
