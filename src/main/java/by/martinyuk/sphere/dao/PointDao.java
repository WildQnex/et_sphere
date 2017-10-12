package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.entity.Point;

import java.util.List;
import java.util.Optional;

public interface PointDao extends GenericDao<Point> {

    @Override
    List<Point> readAll();

    @Override
    Optional<Point> readById(long id);

    @Override
    boolean update(Point entity);

    @Override
    boolean delete(long id);

    @Override
    boolean create(Point entity);

}
