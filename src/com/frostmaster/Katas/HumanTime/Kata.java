package com.frostmaster.Katas.HumanTime;

public class Kata {

    public static String makeReadable(int seconds) {
        Integer secondsLeft = seconds%3600;
        String readable = String.format("%02d:%02d:%02d", seconds/3600, secondsLeft/60, secondsLeft%60);
        return readable;
    }
}
