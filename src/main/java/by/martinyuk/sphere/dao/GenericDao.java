package by.martinyuk.sphere.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<E> {
    List<E> readAll();

    Optional<E> readById(long id);

    boolean update(E entity);

    boolean delete(long id);

    boolean create(E entity);
}

