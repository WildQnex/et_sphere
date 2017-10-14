package by.martinyuk.sphere.cache;

import by.martinyuk.sphere.entity.Sphere;
import by.martinyuk.sphere.exception.CacheException;
import by.martinyuk.sphere.exception.CacheRuntimeException;
import by.martinyuk.sphere.exception.FactoryException;
import by.martinyuk.sphere.exception.FileReaderException;
import by.martinyuk.sphere.factory.EntityFactory;
import by.martinyuk.sphere.parser.LineParser;
import by.martinyuk.sphere.reader.FileReader;
import by.martinyuk.sphere.validator.LineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class SphereCache {

    private static final Logger LOGGER = LogManager.getLogger(SphereCache.class);
    private static final String DELIMITER = ",";
    private static final String FILE_PATH = "data/data.txt";
    private List<Sphere> spheres;

    private SphereCache() throws CacheException {
        init();
    }

    private void init() throws CacheException {
        spheres = new ArrayList<>();
        try {
            List<String> lines = FileReader.readLines(FILE_PATH);
            for (String line : lines) {
                if (LineValidator.validateSphereLine(line)) {
                    spheres.add((Sphere) EntityFactory.factoryMethod(LineParser.parseLine(line, DELIMITER)));
                }
            }
        } catch (FileReaderException | FactoryException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            throw new CacheException(e);
        }
    }

    public static SphereCache getInstance() {
        return SphereCache.SingletonHolder.INSTANCE;
    }


    public List<Sphere> getAll() {

        return spheres.stream()
                .map(s -> {
                    try {
                        return s.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new CacheRuntimeException("Unable to clone object, id = " + s.getId(), e);
                    }
                })
                .collect(Collectors.toList());
    }


    public Optional<Sphere> getById(long id) {
        return spheres.stream()
                .filter(s -> s.getId() == id)
                .map(s -> {
                    try {
                        return s.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException("Unable to clone object, id = " + s.getId(), e);
                    }
                })
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
        private static final SphereCache INSTANCE;

        static {
            try {
                Object obj = new Object();

                INSTANCE = new SphereCache();
            } catch (CacheException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
