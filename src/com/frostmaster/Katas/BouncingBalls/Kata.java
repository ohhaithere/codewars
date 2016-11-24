package com.frostmaster.Katas.BouncingBalls;

/**
 * Created by User on 22.11.2016.
 */
public class Kata {

    public static int bouncingBall(double h, double bounce, double window) {
        if (bounce >= 1 || h < 0 || bounce < 0 || window < 0 || h == window) {
            return -1;
        }

        int ballDownTimes = 1;
        while (true) {
            h = h * bounce;
            if (h > window) {
                ballDownTimes += 2;
            } else {
                break;
            }
        }

        return ballDownTimes;
    }

}
