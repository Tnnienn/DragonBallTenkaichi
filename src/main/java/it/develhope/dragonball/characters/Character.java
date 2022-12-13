package it.develhope.dragonball.characters;

import it.develhope.dragonball.attacks.Attack;
import it.develhope.dragonball.attacks.PhysicalAttack;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public abstract class Character {

    protected String name;
    protected Races race;
    protected int lifePoint;
    protected int strength;
    protected double defenceRate;
    protected double dodgeRate;
    protected List<Attack> attackList = new ArrayList<>(5);


    public Character(String name, Races race, int lifePoint, int strength, double defenceRate, double dodgeRate) throws RuntimeException{
        this.name = name;
        this.race = race;
        this.lifePoint = lifePoint;
        this.strength = strength;
        if(0 <= defenceRate && defenceRate <= 1) {
            this.defenceRate = defenceRate;
        } else {
            throw new RuntimeException("Defence Rate must be between 0 and 1");
        }
        if(0 <= dodgeRate && dodgeRate <= 1) {
            this.dodgeRate = dodgeRate;
        } else {
            throw new RuntimeException("Dodge Rate must be between 0 and 1");
        }
        attackList.add(new PhysicalAttack(strength, dodgeRate));
        System.out.printf("%s is ready to fight%n", this.name);
    }

    public Character() {

    }

    public Attack choseAttack() {
        Random random = new Random();
        int choice = random.nextInt(0, 5);
        return attackList.get(choice);
    }

    public int attack(Character characterEnemy, StringBuilder result) {
        Attack attack = this.choseAttack();
        double success = attack.getSuccessRate() * characterEnemy.getDodgeRate();
        if((Math.random() + 0.01) <= success) {
            int damage = (int) (attack.getStrength() * characterEnemy.getDefenceRate());
            //System.out.printf("%s:\"Ouch!!\"%n", characterEnemy.getName());
            result.append(characterEnemy.getName()).append(": \"Ouch!!\"").append("\n");
            return damage;
        } else {
            //System.out.printf("%s:\"Dodge!!\"%n", characterEnemy.getName());
            result.append(characterEnemy.getName()).append(": \"Dodge!!\"").append("\n");
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append("\n");
        sb.append("Race: ").append(this.race).append("\n");
        sb.append("Life Points: ").append(this.lifePoint).append("\n");
        sb.append("Strength: ").append(this.strength).append("\n");
        sb.append("Defence Rate: ").append(this.defenceRate).append("\n");
        sb.append("Dodge Rate: ").append(this.dodgeRate).append("\n");
        return sb.toString().trim();
    }
}
