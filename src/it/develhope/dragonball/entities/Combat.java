package it.develhope.dragonball.entities;

import it.develhope.dragonball.utilities.Logger;

public class Combat {

    private final Character character1;
    private final Character character2;
    private static int fightNumber = 0;

    public Combat(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    public void fight() {
        double choice = Math.random();
        Character firstAttacker;
        Character secondAttacker;
        if(choice <= 0.5) {
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
                firstAttacker.getName() + " Vs " + secondAttacker.getName() + "\n"
                + winner.getName() + " Wins\n" + loser.getName() + " Lost\n\n"
        );

        System.out.println("------------------------------------");
        System.out.printf("\t\t\t%s Wins%n", winner.getName());
        System.out.printf("\t\t\t%s Lost%n", loser.getName());
        System.out.println("------------------------------------");


    }
}
