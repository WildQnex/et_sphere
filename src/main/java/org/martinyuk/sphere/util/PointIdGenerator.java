package org.martinyuk.sphere.util;

public class PointIdGenerator {

    private static boolean ifNotTest = true;
    private static long id = 1;

    private PointIdGenerator() {
    }

    public static long nextId() {
        return (ifNotTest) ? id++ : id;
    }

    public static void startTest() {
        ifNotTest = false;
    }

    public static void stopTest() {
        ifNotTest = true;
    }
}
