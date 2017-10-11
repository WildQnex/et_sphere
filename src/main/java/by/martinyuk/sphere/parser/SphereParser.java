package by.martinyuk.sphere.parser;

import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;

public class SphereParser {

    private SphereParser(){}

    public static Sphere parseSphereLine(String line){
        line = line.trim();
        String[] numbersString = line.split(",");
        double[] numbers = new double[4];
        for(int i = 0; i < 4; i++){
            numbers[i] = Double.parseDouble(numbersString[i]);
        }
        return new Sphere(numbers[0], numbers[1], numbers[2], numbers[3]);
    }

    public static Point parsePointLine(String line){
        line = line.trim();
        String[] numbersString = line.split(",");
        double[] numbers = new double[3];
        for(int i = 0; i < 3; i++){
            numbers[i] = Double.parseDouble(numbersString[i]);
        }
        return new Point(numbers[0], numbers[1], numbers[2]);
    }
}
