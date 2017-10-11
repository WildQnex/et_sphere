package by.martinyuk.sphere.util;

public class IdGenerator {

    private static long id = 1;

    private IdGenerator(){}

    public static long nextId(){
        return id++;
    }
}
