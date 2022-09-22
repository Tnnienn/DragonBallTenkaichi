package it.develhope.dragonball.entities.attacks;

public class Kaioken implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Kaioken() {
        this.name = "Kaioken";
        this.strength = 90;
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
