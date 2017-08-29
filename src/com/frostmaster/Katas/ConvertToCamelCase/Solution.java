package com.frostmaster.Katas.ConvertToCamelCase;

import java.lang.StringBuilder;


class Solution{

    static String toCamelCase(String s){
        s = s.trim();
        String[] tempArr;
        if(s.contains("_"))
            tempArr = s.split("_");
        else
            tempArr = s.split("-");

        if(tempArr.length > 0){
            if(Character.isUpperCase(tempArr[0].charAt(0))){
                tempArr[0] = tempArr[0].substring(0, 1) + tempArr[0].substring(1, tempArr[0].length()).toLowerCase();

            } else {
                tempArr[0] = tempArr[0].toLowerCase();
            }
        }

        for(int i = 1; i < tempArr.length; i++){
            tempArr[i] = tempArr[i].substring(0, 1).toUpperCase() + tempArr[i].substring(1, tempArr[i].length()).toLowerCase();
        }

        String result = "";

        for(int i = 0; i < tempArr.length; i++){
            result = result + tempArr[i];
        }

        System.out.println(result);

        return result;
    }
}