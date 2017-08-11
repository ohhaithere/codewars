package com.frostmaster.Katas.BiggerNumber;

/**
 * Created by Igor_Usachev on 8/2/2017.
 */
public class Kata
{
  /*  public static long nextBiggerNumber(long n)
    {
        String temp = Long.toString(n);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = Character.getNumericValue(temp.charAt(i));
        }

        ArrayList<Integer> woah = new ArrayList<>();
        for(int i = 0; i< newGuess.length; i++){
            woah.add(newGuess[i]);
        }

        Collections.sort(woah);
        Collections.reverse(woah);

        temp = "";
        for(Integer i : woah){
            temp+=i.toString();
        }

        long a = Long.parseLong(temp);
        if(a > n)
            return a;
        else
            return -1;
    }*/

    public static long nextBiggerNumber(long n)
    {
        char[] aStr = Long.toString(n).toCharArray();
        int len = aStr.length;
        int i;
        for (i = len - 1; i > 1; i--) {
            if (aStr[i] > aStr[i - 1]) break;
        }
        if (i == 1 && aStr[i] < aStr[i - 1]) return -1;
        int ele = aStr[i - 1] - '0';
        int minMax = aStr[i] - '0';
        int minMaxIdx = i;
        for (int j = i; j < len; j++) {
            int cur = aStr[j] - '0';
            if (cur < minMax && cur > ele) {
                minMax = cur;
                minMaxIdx = j;
            }
        }
        swap(aStr, i - 1, minMaxIdx);
        sort(aStr, i, len);
        long result = Long.parseLong(new String(aStr));
        if(result == n)
            return -1;
        else
            return result;
    }

    private static void sort(char[] aStr, int i, int len) {
        for (int j = i; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                if (aStr[j] > aStr[k]) {
                    swap(aStr, j, k);
                }
            }
        }
    }

    private static void swap(char[] aStr, int j, int k) {
        char temp = aStr[j];
        aStr[j] = aStr[k];
        aStr[k] = temp;
    }
}
