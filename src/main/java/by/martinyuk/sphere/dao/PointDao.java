package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.entity.Point;

import java.util.List;

public interface PointDao extends GenericDao<Point> {

    @Override
    List<Point> getAll();

    @Override
    Point read(long id);

    @Override
    boolean update(Point entity);

    @Override
    boolean delete(long id);

    @Override
    boolean create(Point entity);

}
