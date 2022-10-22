package it.develhope.dragonball.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Combat {

    private Character character1;
    private Character character2;
    private String path;

    public Combat(Character character1, Character character2, String path) {
        this.character1 = character1;
        this.character2 = character2;
        this.path = path;
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
        System.out.printf("\t\t\t%s Lost%n", loser.getName());
        System.out.println("----------------------------------");

        result.append("----------------------------------\n\t\t\t").append(winner.getName()).append(" Wins\n----------------------------------\n");
        result.append("----------------------------------\n\t\t\t").append(loser.getName()).append(" Lost\n----------------------------------\n");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write(result.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
