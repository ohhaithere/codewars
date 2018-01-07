package com.frostmaster.Katas.ExpandedForm;

public class Kata {

    public static String expandedForm(int num)
    {
        String number = Integer.toString(num);
        char[] numbers = number.toCharArray();
        String result = "";

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == '0')
                continue;
            result += " + " + numbers[i];
            if(i < numbers.length - 1){
                for(int j = i + 1; j < numbers.length; j++){
                    result += "0";
                }
            }

        }

        result = result.substring(3, result.length());
        return result;
    }

}
