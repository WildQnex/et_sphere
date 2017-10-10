package by.martinyuk.sphere.dao;

import java.util.List;

public interface GenericDao<E>{
    List<E> getAll();
    E read(long id);
    boolean update(E entity);
    boolean delete(long id);
    boolean create(E entity);
}

