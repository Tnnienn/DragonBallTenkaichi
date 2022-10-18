package it.develhope.dragonball.entities.attacks;

public abstract class Skill implements Attack {

    protected String name;
    protected int strength;
    protected double successRate;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public double getSuccessRate() {
        return successRate;
    }

}
