package by.martinyuk.sphere.dao.Impl;

import by.martinyuk.sphere.dao.SphereDao;
import by.martinyuk.sphere.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereDaoImpl implements SphereDao {
    @Override
    public List<Sphere> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Sphere getEntityById(long id) {
        return null;
    }

    @Override
    public Sphere update(Sphere entity) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(Sphere entity) {
        return false;
    }
}
