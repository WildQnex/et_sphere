package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.entity.Sphere;

import java.util.List;

public interface SphereDao extends GenericDao<Sphere>{
    @Override
    List<Sphere> getAll();

    @Override
    Sphere getEntityById(long id);

    @Override
    Sphere update(Sphere entity);

    @Override
    boolean delete(long id);

    @Override
    boolean create(Sphere entity);
}
