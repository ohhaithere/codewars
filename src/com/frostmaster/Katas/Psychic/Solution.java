package com.frostmaster.Katas.Psychic;

import java.lang.reflect.Field;
import java.util.Random;

public class Solution {

    private static final long seed = System.currentTimeMillis();
    private static final Random random = new Random(seed);

    static {
        setup();
    }

    public static double guess() {
        return random.nextDouble();
    }

    private static void setup() {
        try {
            Class<?> randomGeneratorClass = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");

            Field randomNumberGeneratorField = randomGeneratorClass.getDeclaredField("randomNumberGenerator");
            randomNumberGeneratorField.setAccessible(true);
            Random random = (Random) randomNumberGeneratorField.get(null);

            random.setSeed(seed);
        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
