package com.frostmaster.Katas.BreadcrumbGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String generate_bc(String url, String separator) {
        System.out.println(url);
        url = url.replace("http://", "");
        url = url.replace("https://", "");
        if(url.substring(url.length() - 1).equals("/")){
            url = url.substring(0, url.length() - 1);
        }
        String[] splitted = url.split("/");
        String[] toIgnore = new String[]{"the","of","in","from","by","with","and", "or", "for", "to", "at", "a"};
        List<String> ignoreList = Arrays.asList(toIgnore);
        String start;
        if(splitted.length > 1) {
            start = "<a href=\"/\">HOME</a>" + separator;
        } else {
            start = "<span class=\"active\">HOME</span>";
        }

        if(splitted.length == 2){
            if(splitted[1].contains("index.html")){
                start = "<span class=\"active\">HOME</span>";
                return start;
            }
        }

        String prev = "";
        for(int i = 1; i < splitted.length; i++){

            if(i == splitted.length - 2){
                if((splitted[i + 1].contains("index")) || (splitted[i + 1].substring(splitted[i + 1].length() - 1).equals("?")) ||
                        (splitted[i + 1].substring(splitted[i + 1].length() - 1).equals("#")) || (splitted[i + 1].substring(0, 1).equals("?")) ||
                        (splitted[i + 1].substring(0, 1).equals("#"))){
                    String finalString = splitted[i];
                    if(finalString.contains(".")){
                        String[] removeShit = finalString.split("\\.");
                        finalString = removeShit[0];
                    }
                    if(finalString.contains("#")){
                        String[] removeShit = finalString.split("#");
                        finalString = removeShit[0];
                    }
                    if(finalString.contains("?")){
                        String[] removeShit = finalString.split("\\?");
                        finalString = removeShit[0];
                    }
                    if(finalString.length() <= 30){
                        start = start + "<span class=\"active\">" + finalString.toUpperCase().replace("-", " ") + "</span>";
                    } else {
                        String toSplit =  splitted[i];
                        String acronym = "";
                        toSplit = toSplit.replaceAll("-+", "-");
                        String[] splittedAcronym = toSplit.split("-");
                        for(String word : splittedAcronym){
                            if(ignoreList.contains(word)){
                                continue;
                            }
                            acronym = acronym + word.substring(0, 1);
                        }
                        start = start + "<span class=\"active\">" + acronym.toUpperCase() + "</span>";
                    }
                    break;
                }
            }

            if(i == splitted.length - 1){
                String finalString = splitted[i];
                if(finalString.contains(".")){
                    String[] removeShit = finalString.split("\\.");
                    finalString = removeShit[0];
                }
                if(finalString.contains("#")){
                    String[] removeShit = finalString.split("#");
                    finalString = removeShit[0];
                }
                if(finalString.contains("?")){
                    String[] removeShit = finalString.split("\\?");
                    finalString = removeShit[0];
                }
                System.out.println(finalString);
                if(finalString.length() <= 30){
                    start = start + "<span class=\"active\">" + finalString.toUpperCase().replace("-", " ") + "</span>";
                } else {
                    String toSplit =  splitted[i];
                    String acronym = "";
                    String[] splittedAcronym = toSplit.split("-");
                    for(String word : splittedAcronym){
                        if(ignoreList.contains(word)){
                            continue;
                        }
                        acronym = acronym + word.substring(0, 1);
                    }
                    start = start + "<span class=\"active\">" + acronym.toUpperCase() + "</span>";
                }
                continue;
            }

            String string = splitted[i];
            if(string.length() <= 30){
                start = start + "<a href=\"" + prev + "/" + string + "/\">" + string.toUpperCase().replace("-", " ") + "</a>" + separator;
                prev = "/" + string;
            } else {
                String toSplit =  splitted[i];
                String acronym = "";
                toSplit = toSplit.replaceAll("-+", "-");
                String[] splittedAcronym = toSplit.split("-");
                for(String word : splittedAcronym){
                    if(ignoreList.contains(word)){
                        continue;
                    }
                    acronym = acronym + word.substring(0, 1);
                }
                start = start + "<a href=\"" + prev + "/" + string + "/\">" + acronym.toUpperCase() + "</a>" + separator;
                prev = "/" + string;
            }
        }

        return start;
    }

}
