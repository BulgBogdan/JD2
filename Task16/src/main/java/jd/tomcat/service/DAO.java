package jd.tomcat.service;

import java.util.List;

public interface DAO<T> {

    void create(T t);

    List<T> getAll(Class<T> type);
}
