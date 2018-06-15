package com.frostmaster.Katas.UnflattenaListEasy;

import java.util.ArrayList;

public class Kata {

    public static Object[] unflatten(int[] flatArray) {

        ArrayList<Object> result = new ArrayList<>();

        int n = 0;
        while (n < flatArray.length){
            if(flatArray[n] < 3){
                result.add(flatArray[n]);
                n = n + 1;
            } else {
                int toTake;
                if(n + flatArray[n] > flatArray.length){
                    toTake = flatArray.length - n;
                } else {
                    toTake = flatArray[n];
                }
                int taken[] = new int[toTake];
                for(int i = 0; i < toTake; i++){
                    taken[i] = flatArray[n];
                    n = n + 1;
                }
                result.add(taken);
            }
        }

        Object[] resultArr = new Object[result.size()];
        for(int i = 0; i < result.size(); i++){
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

}
