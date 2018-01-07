package com.frostmaster.Katas.SpinWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SpinWords {

    public static String spinWords(String sentence) {
        String[] test = sentence.split(" ");
        for(int i = 0; i < test.length; i++){
            if(test[i].length() >= 5){
                char[] word = test[i].toCharArray();
                for(int j = 0; j < word.length / 2; j++)
                {
                    char temp = word[j];
                    word[j] = word[word.length - j - 1];
                    word[word.length - j - 1] = temp;
                }
                String newWord = new String(word);
                test[i] = newWord;
            }
        }
        String stringToReturn = "";
        for(int i = 0;i < test.length; i++){
            stringToReturn += test[i];
            stringToReturn += " ";
        }
        stringToReturn = stringToReturn.trim();
        return stringToReturn;
    }

}
