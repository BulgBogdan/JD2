package hibernateConnect.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> {

    void create(T t);

    T get(Serializable id);

    void update(T t);

    boolean delete(T t);

    List<T> getAll();
}
