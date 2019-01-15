package com.frostmaster.Katas.GreenNumber;

import java.math.BigInteger;

public class Solution {

    public static BigInteger get(int n) {
        String initInt = String.valueOf(n);
        String result = new String(String.valueOf(n*n));
        String substring = result.substring(result.length() - initInt.length(), result.length());
        if(substring.equals(initInt))
            return new BigInteger()
        return null;
    }

}
