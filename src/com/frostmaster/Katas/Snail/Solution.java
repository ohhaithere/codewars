package com.frostmaster.Katas.Snail;

import java.util.ArrayList;

public class Solution {

    public static int[] snail(int[][] array) {
        int rowStart = 0;
        int rowLength = array.length - 1;

        ArrayList<Integer> result = new ArrayList<>();

        int colStart = 0;
        int colLength = array[0].length - 1;

        while (rowStart <= rowLength && colStart <= colLength) {

            for (int i = rowStart; i <= colLength; i++) {
                System.out.print(array[rowStart][i] + " ");
                result.add(array[rowStart][i]);
            }

            for (int j = rowStart + 1; j <= rowLength; j++) {
                System.out.print(array[j][colLength] + " ");
                result.add(array[j][colLength]);
            }

            if (rowStart + 1 <= rowLength) {
                for (int k = colLength - 1; k >= colStart; k--) {
                    System.out.print(array[rowLength][k] + " ");
                    result.add(array[rowLength][k]);
                }
            }
            if (colStart + 1 <= colLength) {
                for (int k = rowLength - 1; k > rowStart; k--) {
                    System.out.print(array[k][colStart] + " ");
                    result.add(array[k][colStart]);
                }
            }

            rowStart++;
            rowLength--;
            colStart++;
            colLength--;
        }

        int[] resultArr = new int[result.size()];

        for(int i = 0; i < resultArr.length; i++){
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

}
