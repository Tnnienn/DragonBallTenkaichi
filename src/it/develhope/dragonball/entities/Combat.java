package it.develhope.dragonball.entities;

import it.develhope.dragonball.utilities.Logger;

import java.util.Random;

public class Combat {

    private final Character character1;
    private final Character character2;

    public Combat(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
    }



    public void fight() {
        Random random = new Random();
        boolean coin = random.nextBoolean();
        Character firstAttacker;
        Character secondAttacker;
        if(coin) {
            firstAttacker = character1;
            secondAttacker = character2;
        } else {
            firstAttacker = character2;
            secondAttacker = character1;
        }
        int lifePointFirstAttacker = firstAttacker.getLifePoint();
        int lifePointSecondAttacker = secondAttacker.getLifePoint();
        while(lifePointFirstAttacker > 0 && lifePointSecondAttacker > 0) {
            int damageFirstAttacker = firstAttacker.attack(secondAttacker);
            lifePointSecondAttacker -= damageFirstAttacker;
            int damageSecondAttacker = secondAttacker.attack(firstAttacker);
            lifePointFirstAttacker -= damageSecondAttacker;
        }
        Character winner;
        Character loser;
        if(lifePointFirstAttacker <= 0) {
            winner = secondAttacker;
            loser = firstAttacker;
        } else {
            winner = firstAttacker;
            loser = secondAttacker;
        }

        Logger.write(
                firstAttacker.getName() + " Vs " + secondAttacker.getName() + "\t\t|\t\t"
                + "WIN: " + winner.getName() + "\n"
        );

        System.out.println("------------------------------------");
        System.out.printf("\t\t\t%s Wins%n", winner.getName());
        System.out.printf("\t\t\t%s Lost%n", loser.getName());
        System.out.println("------------------------------------");


    }
}
