package com.frostmaster.Katas.TriangularTreasure;

/**
 * Created by User on 20.11.2016.
 */
public class Kata {
    public static int triangular(int n) {
        int sum = 0;
        for(int i = n; i > 0; i--){
            sum+=i;
        }
        return sum;
    }
}
