package com.frostmaster.Katas.PathFinder1;

public class Kata {

    static boolean pathFinder(String maze) {
        System.out.println(maze);
        String[] splitted = maze.split("\n");
        int[] position = new int[]{0,0};

        boolean canGo = true;

        for(int i = 0; i <= splitted.length - 1; i++){
            if(i != splitted.length - 1){
                if(splitted[i + 1].charAt(position[0]) != 'W'){
                    position[1] = position[1] + 1;
                    continue;
                } else {
                    boolean found = false;
                    for(int j = position[0] + 1; i < splitted[i].length() - 1; i++){
                        if(splitted[i].charAt(j) != 'W'){
                            if(splitted[i + 1].charAt(position[j]) != 'W'){
                                 position[0] = j;
                                 position[1] = position[1] + 1;
                                 found = true;
                            } else {
                                break;
                            }
                        }
                    }
                    if(found){
                        continue;
                    } else {
                        canGo = false;
                        break;
                    }
                }
            } else {
                for(int k = position[0]; k < splitted[i].length() - 1; k++){
                    if(splitted[i].charAt(k) != 'W'){
                        continue;
                    } else {
                        canGo = false;
                        break;
                    }
                }
            }

        }
        return canGo;
    }


}
