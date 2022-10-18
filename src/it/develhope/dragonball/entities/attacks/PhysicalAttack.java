package it.develhope.dragonball.entities.attacks;

public class PhysicalAttack extends Skill {

    public PhysicalAttack(int strength, double successRate) {
        this.name = "Physical Attack";
        this.strength = strength;
        this.successRate = successRate;
    }

}
