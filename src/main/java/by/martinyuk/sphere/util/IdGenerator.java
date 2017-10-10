package by.martinyuk.sphere.util;

public class IdGenerator {
    private static long id = 1;

    public static long getId(){
        return id++;
    }
}
