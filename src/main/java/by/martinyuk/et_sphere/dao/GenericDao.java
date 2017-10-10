package by.martinyuk.et_sphere.dao;

import java.util.List;

public interface GenericDao<E>{
    List<E> getAll();
    E getEntityById(long id);
    E update(E entity);
    boolean delete(long id);
    boolean create(E entity);
}

