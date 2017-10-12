package by.martinyuk.sphere.cache;

import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Cache {

    private List<Sphere> spheres;

    private Cache() {
        spheres = new ArrayList<>();
        spheres.add(new Sphere(new Point(1, 2, 3), 6));
        spheres.add(new Sphere(new Point(2, 4, 2), 1));
    }


    public static Cache getInstance() {
        return Cache.SingletonHolder.INSTANCE;
    }


    public List<Sphere> getAll() {
        return spheres.stream()
                .map(Sphere::clone)
                .collect(Collectors.toList());
    }


    public Optional<Sphere> getById(long id) {
        return spheres.stream()
                .filter(s -> s.getId() == id)
                .map(Sphere::clone)
                .findAny();
    }

    public boolean update(Sphere entity) {
        Optional<Sphere> sphere = spheres.stream()
                .filter(s -> s.getId() == entity.getId())
                .findAny();
        if (!sphere.isPresent()) {
            return false;
        }
        sphere.get().setCenter(entity.getCenter());
        sphere.get().setRadius(entity.getRadius());
        return true;
    }

    public boolean delete(long id) {
        Optional<Sphere> sphere = spheres.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        if (!sphere.isPresent()) {
            return false;
        }
        spheres.remove(sphere.get());
        return true;
    }

    public boolean create(Sphere entity) {
        Optional<Sphere> sphere = spheres.stream()
                .filter(s -> s.getId() == entity.getId())
                .findAny();
        if (sphere.isPresent()) {
            return false;
        }
        spheres.add(entity);
        return true;
    }

    private static class SingletonHolder {
        private static final Cache INSTANCE;

        static {
            try {
                Object obj = new Object();

                INSTANCE = new Cache();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
