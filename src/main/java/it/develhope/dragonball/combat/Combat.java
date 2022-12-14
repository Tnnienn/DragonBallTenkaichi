package it.develhope.dragonball.combat;

import it.develhope.dragonball.characters.Character;
import lombok.AllArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@AllArgsConstructor
public class Combat {

    private Character character1;
    private Character character2;
    private String path;

    public Combat(Character character1, Character character2) {
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
        System.out.printf("\t\t\t%s Lost%n", loser.getName());
        System.out.println("----------------------------------");

        result.append("----------------------------------\n\t\t\t").append(winner.getName()).append(" Wins\n----------------------------------\n");
        result.append("----------------------------------\n\t\t\t").append(loser.getName()).append(" Lost\n----------------------------------\n");

        if (this.path != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
                bw.write(result.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Character 1: \n").append(this.character1).append("\n");
        sb.append("------------------------\n");
        sb.append("Character 2: \n").append(this.character2).append("\n");
        return sb.toString().trim();
    }
}
