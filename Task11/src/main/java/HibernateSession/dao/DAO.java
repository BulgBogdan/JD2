package HibernateSession.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> {

    void create(T t);

    T get(Class<T> type, Serializable id);

    void update(T t);

    void delete(Class<T> type, Serializable id);

    List<T> getAll(Class<T> type);
}
