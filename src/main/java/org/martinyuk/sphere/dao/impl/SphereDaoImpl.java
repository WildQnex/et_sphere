package org.martinyuk.sphere.dao.impl;

import org.martinyuk.sphere.cache.SphereCache;
import org.martinyuk.sphere.dao.SphereDao;
import org.martinyuk.sphere.entity.Sphere;

import java.util.List;
import java.util.Optional;

public class SphereDaoImpl implements SphereDao {

    private SphereCache sphereCache = SphereCache.getInstance();

    @Override
    public List<Sphere> readAll() {
        return sphereCache.getAll();
    }

    @Override
    public Optional<Sphere> readById(long id) {
        return sphereCache.getById(id);
    }

    @Override
    public boolean update(Sphere entity) {
        return sphereCache.update(entity);
    }

    @Override
    public boolean delete(long id) {
        return sphereCache.delete(id);
    }

    @Override
    public boolean create(Sphere entity) {
        return sphereCache.create(entity);
    }
}
