package com.frostmaster.Katas.IsMyFriendCheating;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by frostymaster on 26.11.2016.
 */
public class Kata {

    public static List<long[]> removNb(long n) {
        LinkedList<long[]> pairs = new LinkedList<>();
        long sum = n * (n + 1) / 2;
        long lowerBound = ((n - 1) * n / 2) / (n + 1);
        long upperBound = (long) Math.sqrt(sum + 1) - 1;
        for (long a = upperBound; a >= lowerBound; a--) {
            long b = (sum - a)/(a + 1);
            if (a * b + a + b == sum) {
                pairs.addFirst(new long[]{a, b});
                pairs.addLast(new long[]{b, a});
            }
        }
        return pairs;
    }

}
