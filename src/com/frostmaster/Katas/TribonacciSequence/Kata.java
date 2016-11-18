package com.frostmaster.Katas.TribonacciSequence;

import java.util.Arrays;

/**
 * Created by User on 18.11.2016.
 */
public class Kata {
    public static double[] tribonacci(double[] s, int n) {
        double test[] =  new double[n];
        if(n == 0)
            return test;

        if(n > 3){
            test[0] = s[0];
        test[1] = s[1];
        test[2] = s[2];
        for(int i = 3; i < n; i++){
            test[i] = test[i-1] + test[i - 2] + test[i - 3];
        }
    }
        else{
        for(int i = 0; i < n; i++){
            test[i] = s[i];
        }
    }
        System.out.print(Arrays.toString(test));
        return test;
    }
}
