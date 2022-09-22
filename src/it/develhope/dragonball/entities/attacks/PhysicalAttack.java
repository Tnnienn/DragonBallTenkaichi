package it.develhope.dragonball.entities.attacks;

public class PhysicalAttack implements Attack {

    private final String name;
    private final int strength;
    private final double successRate;

    public PhysicalAttack(int strength) {
        this.name = "Physical Attack";
        this.strength = strength;
        this.successRate = 0.9;
    }

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
