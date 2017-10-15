package org.martinyuk.sphere.util;

public class IdGenerator {

    private static boolean ifNotTest = true;
    private static long id = 1;

    private IdGenerator() {
    }

    public static long nextId() {
        return (ifNotTest) ? id++ : id;
    }

    public static void startTest() {
        ifNotTest = false;
    }
}
