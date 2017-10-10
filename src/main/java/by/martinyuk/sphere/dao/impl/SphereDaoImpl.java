package by.martinyuk.sphere.dao.impl;

import by.martinyuk.sphere.cache.Cache;
import by.martinyuk.sphere.dao.SphereDao;
import by.martinyuk.sphere.entity.Sphere;
import java.util.List;
import java.util.Optional;

public class SphereDaoImpl implements SphereDao {

    private Cache cache = Cache.getInstance();

    @Override
    public List<Sphere> getAll() {
        return cache.getSpheres();
    }

    @Override
    public Sphere read(long id) {
        List<Sphere> spheres = cache.getSpheres();
        return spheres.stream()
                .filter(sphere -> sphere.getId() == id)
                .findAny()
                .get();
    }

    @Override
    public boolean update(Sphere entity) {
        Optional<Sphere> sphere = cache.getSpheres().stream()
                .filter(s -> s.getId() == entity.getId())
                .findAny();
        if(!sphere.isPresent()){
            return false;
        }
        sphere.get().setCenter(entity.getCenter());
        sphere.get().setRadius(entity.getRadius());
        return true;
    }

    @Override
    public boolean delete(long id) {
        List<Sphere> spheres = cache.getSpheres();
        Optional<Sphere> sphere = spheres.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        if(!sphere.isPresent()){
            return false;
        }
        spheres.remove(sphere.get());
        return true;
    }

    @Override
    public boolean create(Sphere entity) {
        List<Sphere> spheres = cache.getSpheres();
        Optional<Sphere> sphere = spheres.stream()
                .filter(s -> s.getId() == entity.getId())
                .findAny();
        if(sphere.isPresent()){
            return false;
        }
        spheres.add(entity);
        return true;
    }
}
