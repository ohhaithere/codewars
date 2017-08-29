package com.frostmaster.Katas.DirectionsReduction;

import com.sun.tools.javac.util.ArrayUtils;

public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        String tempString = "";
        boolean containsUseless = true;

        for(int i = 0; i < arr.length; i++){
            tempString+=arr[i];
        }

        while(containsUseless){
            if(tempString.contains("WESTEAST")){
                tempString = tempString.replace("WESTEAST", "");
                containsUseless = true;
            } else{
                containsUseless = false;
            }
            if(tempString.contains("EASTWEST")){
                tempString = tempString.replace("EASTWEST", "");
                containsUseless = true;
            } else{
                containsUseless = false;
            }
            if(tempString.contains("NORTHSOUTH")){
                tempString = tempString.replace("NORTHSOUTH", "");
                containsUseless = true;
            } else{
                containsUseless = false;
            }
            if(tempString.contains("SOUTHNORTH")){
                tempString = tempString.replace("SOUTHNORTH", "");
                containsUseless = true;
            } else{
                containsUseless = false;
            }
        }

        tempString = tempString.replace("WEST", "WEST,");
        tempString = tempString.replace("EAST", "EAST,");
        tempString = tempString.replace("NORTH", "NORTH,");
        tempString = tempString.replace("SOUTH", "SOUTH,");
        int lg = tempString.length();
        if(lg != 0) {
            tempString = tempString.substring(0, tempString.length() - 1);
            return tempString.split(",");
        } else
            return new String[] {};

       // System.out.println(tempString);


        //return tempString.split(",");
    }

}
