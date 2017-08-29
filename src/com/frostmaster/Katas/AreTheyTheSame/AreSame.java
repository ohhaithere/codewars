package com.frostmaster.Katas.AreTheyTheSame;

import java.util.Arrays;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if(a == null || b == null)
            return false;

        if(a.length == 0 || b.length == 0)
            return false;

        if(a.length != b.length)
            return false;

        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println("");

        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");

        boolean contains = true;
        for(int i = 0; i < b.length; i++){
            int sqrt = (int) Math.sqrt(b[i]);
            if(contains(a, sqrt) || contains(a, b[i]) || contains(a, sqrt * (-1)))
                continue;
            else {
                contains = false;
                break;
            }
        }
        return contains;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

}
