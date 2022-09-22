package it.develhope.dragonball.entities.attacks;

public class Genkidama implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Genkidama() {
        this.name = "Genkidama";
        this.strength = 200;
        this.successRate = 0.2;
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
