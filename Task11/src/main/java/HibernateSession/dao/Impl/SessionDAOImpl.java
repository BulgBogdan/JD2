package HibernateSession.dao.Impl;

import HibernateSession.dao.DAO;
import HibernateSession.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SessionDAOImpl<T> implements DAO<T> {

    Transaction transaction = null;


    @Override
    public void create(T t) {
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (HibernateException e) {
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
        } catch (HibernateException e) {
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
        } catch (HibernateException e) {
            transaction.rollback();
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
        } catch (HibernateException e) {
            transaction.rollback();
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
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return list;
    }
}
