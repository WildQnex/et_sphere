package by.martinyuk.sphere.dao.impl;

import by.martinyuk.sphere.cache.Cache;
import by.martinyuk.sphere.dao.SphereDao;
import by.martinyuk.sphere.entity.Sphere;

import java.util.List;
import java.util.Optional;

public class SphereDaoImpl implements SphereDao {

    private Cache cache = Cache.getInstance();

    @Override
    public List<Sphere> readAll() {
        return cache.getAll();
    }

    @Override
    public Optional<Sphere> readById(long id) {
        return cache.getById(id);
    }

    @Override
    public boolean update(Sphere entity) {
        return cache.update(entity);
    }

    @Override
    public boolean delete(long id) {
        return cache.delete(id);
    }

    @Override
    public boolean create(Sphere entity) {
        return cache.create(entity);
    }
}
