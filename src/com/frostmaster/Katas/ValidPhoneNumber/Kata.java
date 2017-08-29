package com.frostmaster.Katas.ValidPhoneNumber;

public class Kata {

    public static boolean validPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}"))
            return true;
        else
            return false;
    }

}
