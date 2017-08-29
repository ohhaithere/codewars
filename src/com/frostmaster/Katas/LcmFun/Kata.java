package com.frostmaster.Katas.LcmFun;

import java.util.ArrayList;

public class Kata {

    public static long KiyoLCM(Object[][] a)
    {
        ArrayList<Long> lcm = new ArrayList<Long>();
        long sum = 0;
        for(int i = 0; i < a.length; i++){
            sum = 0;
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] instanceof Integer){
                    if(isOddNumber((int) a[i][j])){
                        sum += (int) a[i][j];
                    }
                }
            }
            lcm.add(sum);
        }

        lcm.remove(0);
        long[] dataForLcm = new long[lcm.size()];

        for(int i = 0; i < lcm.size(); i++){
            dataForLcm[i] = lcm.get(i);
        }



        return lcm(dataForLcm);
    }


    public static boolean isOddNumber(int num) {
        return (num & 1) != 0;
    }

    private static long lcm(long[] input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    private static long lcm(long a, long b)
    {
        if(gcd(a, b) != 0)
            return a * (b / gcd(a, b));
        else
            return 0;
    }


    private static long gcd(long[] input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
