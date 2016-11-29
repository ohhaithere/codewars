package com.frostmaster.Katas.LargeFactorials;

import java.math.BigInteger;

/**
 * Created by frostymaster on 26.11.2016.
 */
public class Kata {

    public static String Factorial(int n) {
        BigInteger sum = new BigInteger("1");
        for(int i = 1; i <= n ; i++){
            BigInteger multiply = new BigInteger(new Integer(i).toString());
            sum = sum.multiply(multiply);
        }
        return sum.toString();
    }

}
