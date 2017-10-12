package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.entity.Sphere;

import java.util.List;
import java.util.Optional;

public interface SphereDao extends GenericDao<Sphere> {
    @Override
    List<Sphere> readAll();

    @Override
    Optional<Sphere> readById(long id);

    @Override
    boolean update(Sphere entity);

    @Override
    boolean delete(long id);

    @Override
    boolean create(Sphere entity);
}
