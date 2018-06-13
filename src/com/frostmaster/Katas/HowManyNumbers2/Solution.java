package com.frostmaster.Katas.HowManyNumbers2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static long[] maxSumDig(long nmax, int maxsm) {
        int count = 0;
        long sum = 0l;
        ArrayList<Long> values = new ArrayList<>();
        for(long i = 1000; i <= nmax; i++){
            int[] arr = getArray(i);
            boolean isOk = true;
            for(int j = 0; j <= arr.length - 4; j++){
                if(((arr[j] + arr[j+1] + arr[j+2] + arr[j+3]) > maxsm)){
                    isOk = false;
                }
            }
            if(isOk){
                count++;
                sum += i;
                values.add(i);
            }
        }

        long[] result = new long[3];
        result[0] = count;
        result[2] = sum;
        result[1] = getMean(values, sum);

        return result;
    }

    public static int[] getArray(long value){
        String temp = Long.toString(value);
        int[] newGuess = new int[temp.length()];
        for (int j = 0; j < temp.length(); j++)
        {
            newGuess[j] = temp.charAt(j) - '0';
        }

        return newGuess;
    }

    public static long getMean(ArrayList<Long> values, Long sum){
        Double mean = (double) sum / values.size();

        return closest(mean, values);
    }

    public static long closest(double of, List<Long> in) {
        double min = Double.MAX_VALUE;
        double closest = of;

        for (long v : in) {
            final double diff = Math.abs(v - of);

            if (diff < min) {
                min = diff;
                closest = v;
            }
        }

        return (long) closest;
    }



}
