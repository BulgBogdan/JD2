package HibernateSession.dao.Impl;

import HibernateSession.dao.DAO;
import HibernateSession.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SessionDAOImpl<T> implements DAO<T> {

    private static final Logger logger = Logger.getLogger(SessionDAOImpl.class);

    Transaction transaction = null;

    @Override
    public void create(T t) {
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            logger.info(t.getClass().getName() + " successfully added. " + t.getClass().getName() + ": " + t);
        } catch (HibernateException e) {
            logger.error("Error " + t.getClass().getName() + " not added", e);
            transaction.rollback();
        }
    }

    @Override
    public T get(Class<T> type, Serializable id) {
        T t = null;
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            t = session.get(type, id);
            transaction.commit();
            logger.info(type.getName() + " successfully founded. " + type.getName() + ": " + t);
        } catch (HibernateException e) {
            logger.error("Error " + type.getName() + " not founded", e);
            transaction.rollback();
        }
        return t;
    }

    @Override
    public void update(T t) {
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
            logger.info(t.getClass().getName() + " successfully updated. " + t.getClass().getName() + ": " + t);
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Error " + t.getClass().getName() + " not updated", e);
        }
    }

    @Override
    public void delete(Class<T> type, Serializable id) {
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            T t = session.get(type, id);
            session.delete(t);
            transaction.commit();
            logger.info(type.getName() + " successfully deleted. " + type.getName() + ": " + t);
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Error " + type.getName() + " not deleted", e);
        }
    }

    @Override
    public List<T> getAll(Class<T> type) {
        List<T> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            list = session.createQuery("from " + type.getName()).list();
            transaction.commit();
            for (T t : list) {
                logger.info(type.getName() + " successfully founded. " + t.getClass().getName() + ": " + t);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Error " + type.getName() + " not founded list", e);
        }
        return list;
    }
}
