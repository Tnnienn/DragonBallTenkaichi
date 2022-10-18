package it.develhope.dragonball.entities;

import it.develhope.dragonball.entities.attacks.Attack;
import it.develhope.dragonball.entities.attacks.PhysicalAttack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Character {

    private String name;
    private Races race;
    private int lifePoint;
    private int strength;
    private double defenceRate;
    private double dodgeRate;
    private List<Attack> attackList = new ArrayList<>(5);


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

    public String getName() {
        return name;
    }

    public Races getRace() {
        return race;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public int getStrength() {
        return strength;
    }

    public double getDefenceRate() {
        return defenceRate;
    }

    public double getDodgeRate() {
        return dodgeRate;
    }

    public List<Attack> getAttackList() { return attackList; }

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
            System.out.printf("%s:\"Ouch!!\"%n", characterEnemy.getName());
            result.append(characterEnemy.getName()).append(": \"Ouch!!\"").append("\n");
            System.out.println();
            return damage;
        } else {
            System.out.printf("%s:\"Dodge!!\"%n", characterEnemy.getName());
            result.append(characterEnemy.getName()).append(": \"Dodge!!\"").append("\n");
            System.out.println();
            return 0;
        }
    }

}
