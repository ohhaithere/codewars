package com.frostmaster.Katas.WhatsaPerfectPowerAnyway;

/**
 * Created by User on 23.11.2016.
 */
public class Kata {

    public static int[] isPerfectPower(int n) {
        for (int i = 2; i < Math.log(n) / Math.log(2) + 1; i++) {
            for (int j = 2; Math.pow(j, i) <= n; j++) {
                if (Math.pow(j, i) == n) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

}
