package org.martinyuk.sphere.util;

public class SphereIdGenerator {

    private static boolean ifNotTest = true;
    private static long sphereId = 1;

    private SphereIdGenerator() {
    }

    public static long nextId() {
        return (ifNotTest) ? sphereId++ : sphereId;
    }

    public static void startTest() {
        ifNotTest = false;
    }

    public static void stopTest() {
        ifNotTest = true;
    }

    public static void reInit() {
        sphereId = 1;
    }
}
