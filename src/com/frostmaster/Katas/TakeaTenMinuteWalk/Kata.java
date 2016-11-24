package com.frostmaster.Katas.TakeaTenMinuteWalk;

/**
 * Created by User on 23.11.2016.
 */
public class Kata {

    public static boolean isValid(char[] walk) {
        if(walk.length != 10)
            return false;

        if(walk[0] == walk[8] && walk[2] == walk[9])
            return true;
        else
            return false;
    }

}
