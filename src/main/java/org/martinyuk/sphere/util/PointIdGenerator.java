package org.martinyuk.sphere.util;

public class PointIdGenerator {

    private static boolean ifNotTest = true;
    private static long pointId = 1;

    private PointIdGenerator() {
    }

    public static long nextId() {
        return (ifNotTest) ? pointId++ : pointId;
    }

    public static void startTest() {
        ifNotTest = false;
    }

    public static void stopTest() {
        ifNotTest = true;
    }
}
