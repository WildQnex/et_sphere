package org.martinyuk.sphere.cache;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.martinyuk.sphere.creator.SphereCreator;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.CacheException;
import org.martinyuk.sphere.exception.FileReaderException;
import org.martinyuk.sphere.parser.LineParser;
import org.martinyuk.sphere.reader.FileReader;
import org.martinyuk.sphere.validator.LineValidator;

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
        try {
            List<String> lines = FileReader.readLines(FILE_PATH);
            spheres = lines.stream()
                    .filter(LineValidator::validateSphereLine)
                    .map(l -> {
                        List<Double> list = LineParser.parseLine(l, DELIMITER);
                        return SphereCreator.createSphere(list);
                    })
                    .collect(Collectors.toList());
        } catch (FileReaderException e) {
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
                        LOGGER.log(Level.ERROR, "Can't clone object = " + s);
                    }
                    return null;
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
                        LOGGER.log(Level.ERROR, "Can't clone object = " + s);
                    }
                    return null;
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
                INSTANCE = new SphereCache();
            } catch (CacheException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
