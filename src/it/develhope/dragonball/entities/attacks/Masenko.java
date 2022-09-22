package it.develhope.dragonball.entities.attacks;

public class Masenko implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Masenko() {
        this.name = "Masenko";
        this.strength = 100;
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
