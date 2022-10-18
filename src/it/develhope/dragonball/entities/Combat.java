package it.develhope.dragonball.entities;

import it.develhope.dragonball.utilities.Logger;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Combat {

    private Character character1;
    private Character character2;
    private String path;

    public Combat(Character character1, Character character2, String path) {
        this.character1 = character1;
        this.character2 = character2;
    }



    public void fight() {
        StringBuilder result = new StringBuilder();
        result.append(character1.getName()).append(" VS ").append(character2.getName()).append("\n");
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
            int damageFirstAttacker = firstAttacker.attack(secondAttacker, result);
            lifePointSecondAttacker -= damageFirstAttacker;
            int damageSecondAttacker = secondAttacker.attack(firstAttacker, result);
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

        System.out.println("----------------------------------");
        System.out.printf("\t\t\t%s Wins%n", winner.getName());
        System.out.println("----------------------------------");

        result.append("----------------------------------\n\t\t\t").append(winner.getName()).append("----------------------------------\n");
        //TODO fix file logging
        /*try (BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.get(path).toFile()))){
            bw.write(result.toString());
        } catch (IOException e) {
            System.out.println(e);
        }*/
    }
}
