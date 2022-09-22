package it.develhope.dragonball.entities.attacks;

public class Taioken implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Taioken() {
        this.name = "Taioken";
        this.strength = 90;
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
