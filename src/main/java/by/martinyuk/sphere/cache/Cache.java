package by.martinyuk.sphere.cache;

import by.martinyuk.sphere.cache.exception.CacheException;
import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import by.martinyuk.sphere.util.Parser;
import by.martinyuk.sphere.util.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<Sphere> spheres;
    private List<Point> points;

    private Cache(){
    }

    public static Cache getInstance(){
        return Cache.SingletonHolder.INSTANCE;
    }

    public void  readPoints(String filePath) throws CacheException {
        List<Point> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(Validator.validatePointLine(line)){
                    list.add(Parser.parsePointLine(line));
                }
            }
        }catch (FileNotFoundException e){
            throw new CacheException("File wasn't found");
        } catch (IOException e){
            throw new CacheException("Can't open file");
        }
        this.points = list;
    }

    public void readSpheres(String filePath) throws CacheException {
        List<Sphere> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(Validator.validateSphereLine(line)){
                    list.add(Parser.parseSphereLine(line));
                }
            }
        }catch (FileNotFoundException e){
            throw new CacheException("File wasn't found");
        } catch (IOException e){
            throw new CacheException("Can't open file");
        }
        this.spheres = list;
    }

    public List<Sphere> getSpheres() {
        return this.spheres;
    }

    public List<Point> getPoints(){
        return this.points;
    }

    private static class SingletonHolder{
        private static final Cache INSTANCE;
        static {
            try {
                INSTANCE = new Cache();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
