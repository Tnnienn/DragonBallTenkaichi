package it.develhope.dragonball.entities.attacks;

public class Kamehameha implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Kamehameha() {
        this.name = "Kamehameha";
        this.strength = 70;
        this.successRate = 0.8;
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
