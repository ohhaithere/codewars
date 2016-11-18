package com.frostmaster.Katas.TwoFightersOneWinner;

/**
 * Created by Igor_Usachev on 11/18/2016.
 */public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacksFirst;
        Fighter attacksSecond;
        if(firstAttacker.equals(fighter1.name)) {
            attacksFirst = fighter1;
            attacksSecond = fighter2;
        } else{
            attacksFirst = fighter2;
            attacksSecond = fighter1;
        }

        int i = 0;

        while(i != 1){
            attacksSecond.health -= attacksFirst.damagePerAttack;
            if(attacksSecond.health <= 0)
                break;
            attacksFirst.health -= attacksSecond.damagePerAttack;
            if(attacksFirst.health <= 0)
                break;
        }

        if(attacksFirst.health < attacksSecond.health)
            return attacksSecond.name;
        else
            return attacksFirst.name;
    }
}
