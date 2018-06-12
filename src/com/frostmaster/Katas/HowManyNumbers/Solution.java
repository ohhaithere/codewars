package com.frostmaster.Katas.HowManyNumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int selNumber(int n, int d) {
        System.out.println("n: " + n);
        System.out.println("d:" + d);
        int count = 0;
        if(n < 12){
            return count;
        }

        for(int i = 12; i <= n; i++) {
            String temp = Integer.toString(i);
            int[] newGuess = new int[temp.length()];
            for (int j = 0; j < temp.length(); j++)
            {
                newGuess[j] = temp.charAt(j) - '0';
            }
            if(!isSorted(newGuess)) {
                continue;
            }
            if(containsDuplicates(newGuess)){
                continue;
            }
            boolean isOk = true;
            for(int j = 0; j < newGuess.length - 1; j++){
                if((Math.abs(newGuess[j + 1] - newGuess[j])) > d) {
                    //System.out.println(d);
                    //System.out.println(newGuess[j + 1] - newGuess[j]);
                    isOk = false;
                    break;
                }
            }

            if(isOk){
                count++;
                System.out.println(i);
            }

        }

        return count;
    }

    public static boolean isSorted(int[] data){
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicates(int[] arr)
    {
        Set<Integer> lump = new HashSet<Integer>();
        for (int i : arr)
        {
            if (lump.contains(i)) return true;
            lump.add(i);
        }
        return false;
    }

}
